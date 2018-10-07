import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IResumoDiario } from 'app/shared/model/resumo-diario.model';
import { ResumoDiarioService } from './resumo-diario.service';

@Component({
    selector: 'jhi-resumo-diario-update',
    templateUrl: './resumo-diario-update.component.html'
})
export class ResumoDiarioUpdateComponent implements OnInit {
    private _resumoDiario: IResumoDiario;
    isSaving: boolean;
    dataLancamentoDp: any;

    constructor(private resumoDiarioService: ResumoDiarioService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ resumoDiario }) => {
            this.resumoDiario = resumoDiario;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.resumoDiario.id !== undefined) {
            this.subscribeToSaveResponse(this.resumoDiarioService.update(this.resumoDiario));
        } else {
            this.subscribeToSaveResponse(this.resumoDiarioService.create(this.resumoDiario));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IResumoDiario>>) {
        result.subscribe((res: HttpResponse<IResumoDiario>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get resumoDiario() {
        return this._resumoDiario;
    }

    set resumoDiario(resumoDiario: IResumoDiario) {
        this._resumoDiario = resumoDiario;
    }
}
