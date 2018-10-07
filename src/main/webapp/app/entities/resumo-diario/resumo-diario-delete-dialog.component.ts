import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IResumoDiario } from 'app/shared/model/resumo-diario.model';
import { ResumoDiarioService } from './resumo-diario.service';

@Component({
    selector: 'jhi-resumo-diario-delete-dialog',
    templateUrl: './resumo-diario-delete-dialog.component.html'
})
export class ResumoDiarioDeleteDialogComponent {
    resumoDiario: IResumoDiario;

    constructor(
        private resumoDiarioService: ResumoDiarioService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.resumoDiarioService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'resumoDiarioListModification',
                content: 'Deleted an resumoDiario'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-resumo-diario-delete-popup',
    template: ''
})
export class ResumoDiarioDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ resumoDiario }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(ResumoDiarioDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.resumoDiario = resumoDiario;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
