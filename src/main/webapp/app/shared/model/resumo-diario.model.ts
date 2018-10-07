import { Moment } from 'moment';

export interface IResumoDiario {
    id?: number;
    dataLancamento?: Moment;
    cocosProcessados?: number;
    cocosDesfibrados?: number;
    cri?: number;
    flococo?: number;
    oleoIndustrialTipoA?: number;
    oleoIndustrialETE?: number;
    torta?: number;
    aguaDeCocoSococo?: number;
    aguaDeCocoVerde?: number;
    caixaPadrao?: number;
    porcentagemCocoGerminado?: number;
    totalDeCacambas?: number;
    numeroDeFardos?: number;
    diaLancamento?: string;
    mesLancamento?: string;
    anoLancamento?: string;
}

export class ResumoDiario implements IResumoDiario {
    constructor(
        public id?: number,
        public dataLancamento?: Moment,
        public cocosProcessados?: number,
        public cocosDesfibrados?: number,
        public cri?: number,
        public flococo?: number,
        public oleoIndustrialTipoA?: number,
        public oleoIndustrialETE?: number,
        public torta?: number,
        public aguaDeCocoSococo?: number,
        public aguaDeCocoVerde?: number,
        public caixaPadrao?: number,
        public porcentagemCocoGerminado?: number,
        public totalDeCacambas?: number,
        public numeroDeFardos?: number,
        public diaLancamento?: string,
        public mesLancamento?: string,
        public anoLancamento?: string
    ) {}
}
