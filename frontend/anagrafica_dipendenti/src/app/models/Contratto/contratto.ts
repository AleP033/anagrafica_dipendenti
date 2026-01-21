import { Dipendente } from "../Dipendente/dipendente";

export class Contratto {

    id?: number;
    tipo?: string;
    dataInizio? : string;
    dataFine? : string;

    dipendente? : Dipendente[]
}
