import { Dipendente } from "../Dipendente/dipendente";

export class Contratto {

    id?: number;
    tip?: string;
    datIni? : string;
    datFin? : string;

    dipRIF? : Dipendente[]
}
