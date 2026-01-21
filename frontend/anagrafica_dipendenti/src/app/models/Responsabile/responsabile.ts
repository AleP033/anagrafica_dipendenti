import { Dipendente } from "../Dipendente/dipendente";
import { Commessa } from "../Commessa/commessa";

export class Responsabile {

    id? : number;
    nome? : string;
    cognome? : string;
    email? : string;
    dataInizio?: string;
    dataFine? : string;

    dipendente? : Dipendente[];
    commessa? : Commessa[]
}
