import { Dipendente } from "../Dipendente/dipendente";
import { Commessa } from "../Commessa/commessa";

export class Responsabile {

    id? : number;
    nome? : string;
    cognome? : string;
    email? : string;
    datInizio?: string;
    datFine? : string;

   dipRIF? : number[];
   comRIF? : number[];
}
