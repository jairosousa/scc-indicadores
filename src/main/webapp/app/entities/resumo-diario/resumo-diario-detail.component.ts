import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IResumoDiario } from 'app/shared/model/resumo-diario.model';

@Component({
    selector: 'jhi-resumo-diario-detail',
    templateUrl: './resumo-diario-detail.component.html'
})
export class ResumoDiarioDetailComponent implements OnInit {
    resumoDiario: IResumoDiario;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ resumoDiario }) => {
            this.resumoDiario = resumoDiario;
        });
    }

    previousState() {
        window.history.back();
    }
}
