import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { SccIndicadoresSharedModule } from 'app/shared';
import {
    ResumoDiarioComponent,
    ResumoDiarioDetailComponent,
    ResumoDiarioUpdateComponent,
    ResumoDiarioDeletePopupComponent,
    ResumoDiarioDeleteDialogComponent,
    resumoDiarioRoute,
    resumoDiarioPopupRoute
} from './';
import { NgxMaskModule } from 'ngx-mask';

const ENTITY_STATES = [...resumoDiarioRoute, ...resumoDiarioPopupRoute];

@NgModule({
    imports: [SccIndicadoresSharedModule, RouterModule.forChild(ENTITY_STATES), NgxMaskModule],
    declarations: [
        ResumoDiarioComponent,
        ResumoDiarioDetailComponent,
        ResumoDiarioUpdateComponent,
        ResumoDiarioDeleteDialogComponent,
        ResumoDiarioDeletePopupComponent
    ],
    entryComponents: [
        ResumoDiarioComponent,
        ResumoDiarioUpdateComponent,
        ResumoDiarioDeleteDialogComponent,
        ResumoDiarioDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SccIndicadoresResumoDiarioModule {}
