import { Dipendente } from "../Dipendente/dipendente";
import { Responsabile } from "../Responsabile/responsabile";

export class Commessa {

    id? : number;
    titolo? : string;
    descrizione? : string;
    dataInizio? : string;
    dataFine? : string;
    importo? : number;

    dipendente? : Dipendente;
    responsabile? : Responsabile;
}
