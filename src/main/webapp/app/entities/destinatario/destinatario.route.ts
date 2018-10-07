import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Destinatario } from 'app/shared/model/destinatario.model';
import { DestinatarioService } from './destinatario.service';
import { DestinatarioComponent } from './destinatario.component';
import { DestinatarioDetailComponent } from './destinatario-detail.component';
import { DestinatarioUpdateComponent } from './destinatario-update.component';
import { DestinatarioDeletePopupComponent } from './destinatario-delete-dialog.component';
import { IDestinatario } from 'app/shared/model/destinatario.model';

@Injectable({ providedIn: 'root' })
export class DestinatarioResolve implements Resolve<IDestinatario> {
    constructor(private service: DestinatarioService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((destinatario: HttpResponse<Destinatario>) => destinatario.body));
        }
        return of(new Destinatario());
    }
}

export const destinatarioRoute: Routes = [
    {
        path: 'destinatario',
        component: DestinatarioComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'sccIndicadoresApp.destinatario.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'destinatario/:id/view',
        component: DestinatarioDetailComponent,
        resolve: {
            destinatario: DestinatarioResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'sccIndicadoresApp.destinatario.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'destinatario/new',
        component: DestinatarioUpdateComponent,
        resolve: {
            destinatario: DestinatarioResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'sccIndicadoresApp.destinatario.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'destinatario/:id/edit',
        component: DestinatarioUpdateComponent,
        resolve: {
            destinatario: DestinatarioResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'sccIndicadoresApp.destinatario.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const destinatarioPopupRoute: Routes = [
    {
        path: 'destinatario/:id/delete',
        component: DestinatarioDeletePopupComponent,
        resolve: {
            destinatario: DestinatarioResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'sccIndicadoresApp.destinatario.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
