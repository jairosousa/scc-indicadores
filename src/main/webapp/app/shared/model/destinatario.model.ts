export interface IDestinatario {
    id?: number;
    nome?: string;
    email?: string;
}

export class Destinatario implements IDestinatario {
    constructor(public id?: number, public nome?: string, public email?: string) {}
}
