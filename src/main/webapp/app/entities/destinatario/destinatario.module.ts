import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { SccIndicadoresSharedModule } from 'app/shared';
import {
    DestinatarioComponent,
    DestinatarioDetailComponent,
    DestinatarioUpdateComponent,
    DestinatarioDeletePopupComponent,
    DestinatarioDeleteDialogComponent,
    destinatarioRoute,
    destinatarioPopupRoute
} from './';

const ENTITY_STATES = [...destinatarioRoute, ...destinatarioPopupRoute];

@NgModule({
    imports: [SccIndicadoresSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        DestinatarioComponent,
        DestinatarioDetailComponent,
        DestinatarioUpdateComponent,
        DestinatarioDeleteDialogComponent,
        DestinatarioDeletePopupComponent
    ],
    entryComponents: [
        DestinatarioComponent,
        DestinatarioUpdateComponent,
        DestinatarioDeleteDialogComponent,
        DestinatarioDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SccIndicadoresDestinatarioModule {}
