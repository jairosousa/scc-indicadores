import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IResumoDiario } from 'app/shared/model/resumo-diario.model';

type EntityResponseType = HttpResponse<IResumoDiario>;
type EntityArrayResponseType = HttpResponse<IResumoDiario[]>;

@Injectable({ providedIn: 'root' })
export class ResumoDiarioService {
    private resourceUrl = SERVER_API_URL + 'api/resumo-diarios';

    constructor(private http: HttpClient) {}

    create(resumoDiario: IResumoDiario): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(resumoDiario);
        return this.http
            .post<IResumoDiario>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(resumoDiario: IResumoDiario): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(resumoDiario);
        return this.http
            .put<IResumoDiario>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IResumoDiario>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IResumoDiario[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(resumoDiario: IResumoDiario): IResumoDiario {
        const copy: IResumoDiario = Object.assign({}, resumoDiario, {
            dataLancamento:
                resumoDiario.dataLancamento != null && resumoDiario.dataLancamento.isValid()
                    ? resumoDiario.dataLancamento.format(DATE_FORMAT)
                    : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.dataLancamento = res.body.dataLancamento != null ? moment(res.body.dataLancamento) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((resumoDiario: IResumoDiario) => {
            resumoDiario.dataLancamento = resumoDiario.dataLancamento != null ? moment(resumoDiario.dataLancamento) : null;
        });
        return res;
    }
}
