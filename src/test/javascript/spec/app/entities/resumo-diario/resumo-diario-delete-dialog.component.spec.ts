/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { SccIndicadoresTestModule } from '../../../test.module';
import { ResumoDiarioDeleteDialogComponent } from 'app/entities/resumo-diario/resumo-diario-delete-dialog.component';
import { ResumoDiarioService } from 'app/entities/resumo-diario/resumo-diario.service';

describe('Component Tests', () => {
    describe('ResumoDiario Management Delete Component', () => {
        let comp: ResumoDiarioDeleteDialogComponent;
        let fixture: ComponentFixture<ResumoDiarioDeleteDialogComponent>;
        let service: ResumoDiarioService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [SccIndicadoresTestModule],
                declarations: [ResumoDiarioDeleteDialogComponent]
            })
                .overrideTemplate(ResumoDiarioDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(ResumoDiarioDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ResumoDiarioService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
