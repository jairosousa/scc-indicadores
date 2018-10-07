import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IDestinatario } from 'app/shared/model/destinatario.model';
import { DestinatarioService } from './destinatario.service';

@Component({
    selector: 'jhi-destinatario-update',
    templateUrl: './destinatario-update.component.html'
})
export class DestinatarioUpdateComponent implements OnInit {
    private _destinatario: IDestinatario;
    isSaving: boolean;

    constructor(private destinatarioService: DestinatarioService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ destinatario }) => {
            this.destinatario = destinatario;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.destinatario.id !== undefined) {
            this.subscribeToSaveResponse(this.destinatarioService.update(this.destinatario));
        } else {
            this.subscribeToSaveResponse(this.destinatarioService.create(this.destinatario));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IDestinatario>>) {
        result.subscribe((res: HttpResponse<IDestinatario>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get destinatario() {
        return this._destinatario;
    }

    set destinatario(destinatario: IDestinatario) {
        this._destinatario = destinatario;
    }
}
