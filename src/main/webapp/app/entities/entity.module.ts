import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { SccIndicadoresResumoDiarioModule } from './resumo-diario/resumo-diario.module';
import { SccIndicadoresDestinatarioModule } from './destinatario/destinatario.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        SccIndicadoresResumoDiarioModule,
        SccIndicadoresDestinatarioModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SccIndicadoresEntityModule {}
