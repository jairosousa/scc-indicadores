import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { ResumoDiario } from 'app/shared/model/resumo-diario.model';
import { ResumoDiarioService } from './resumo-diario.service';
import { ResumoDiarioComponent } from './resumo-diario.component';
import { ResumoDiarioDetailComponent } from './resumo-diario-detail.component';
import { ResumoDiarioUpdateComponent } from './resumo-diario-update.component';
import { ResumoDiarioDeletePopupComponent } from './resumo-diario-delete-dialog.component';
import { IResumoDiario } from 'app/shared/model/resumo-diario.model';

@Injectable({ providedIn: 'root' })
export class ResumoDiarioResolve implements Resolve<IResumoDiario> {
    constructor(private service: ResumoDiarioService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((resumoDiario: HttpResponse<ResumoDiario>) => resumoDiario.body));
        }
        return of(new ResumoDiario());
    }
}

export const resumoDiarioRoute: Routes = [
    {
        path: 'resumo-diario',
        component: ResumoDiarioComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'sccIndicadoresApp.resumoDiario.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'resumo-diario/:id/view',
        component: ResumoDiarioDetailComponent,
        resolve: {
            resumoDiario: ResumoDiarioResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'sccIndicadoresApp.resumoDiario.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'resumo-diario/new',
        component: ResumoDiarioUpdateComponent,
        resolve: {
            resumoDiario: ResumoDiarioResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'sccIndicadoresApp.resumoDiario.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'resumo-diario/:id/edit',
        component: ResumoDiarioUpdateComponent,
        resolve: {
            resumoDiario: ResumoDiarioResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'sccIndicadoresApp.resumoDiario.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const resumoDiarioPopupRoute: Routes = [
    {
        path: 'resumo-diario/:id/delete',
        component: ResumoDiarioDeletePopupComponent,
        resolve: {
            resumoDiario: ResumoDiarioResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'sccIndicadoresApp.resumoDiario.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
