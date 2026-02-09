import { Dipendente } from "../Dipendente/dipendente";

export class Contratto {

    id?: number;
    tipo?: string;
    datInizio? : string;
    datFine? : string;

    dipRIF? : Dipendente[]
}
