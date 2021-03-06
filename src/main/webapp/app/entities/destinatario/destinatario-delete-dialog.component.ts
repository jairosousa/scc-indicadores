import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IDestinatario } from 'app/shared/model/destinatario.model';
import { DestinatarioService } from './destinatario.service';

@Component({
    selector: 'jhi-destinatario-delete-dialog',
    templateUrl: './destinatario-delete-dialog.component.html'
})
export class DestinatarioDeleteDialogComponent {
    destinatario: IDestinatario;

    constructor(
        private destinatarioService: DestinatarioService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.destinatarioService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'destinatarioListModification',
                content: 'Deleted an destinatario'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-destinatario-delete-popup',
    template: ''
})
export class DestinatarioDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ destinatario }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(DestinatarioDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.destinatario = destinatario;
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
