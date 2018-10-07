/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { SccIndicadoresTestModule } from '../../../test.module';
import { ResumoDiarioDetailComponent } from 'app/entities/resumo-diario/resumo-diario-detail.component';
import { ResumoDiario } from 'app/shared/model/resumo-diario.model';

describe('Component Tests', () => {
    describe('ResumoDiario Management Detail Component', () => {
        let comp: ResumoDiarioDetailComponent;
        let fixture: ComponentFixture<ResumoDiarioDetailComponent>;
        const route = ({ data: of({ resumoDiario: new ResumoDiario(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [SccIndicadoresTestModule],
                declarations: [ResumoDiarioDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(ResumoDiarioDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(ResumoDiarioDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.resumoDiario).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
