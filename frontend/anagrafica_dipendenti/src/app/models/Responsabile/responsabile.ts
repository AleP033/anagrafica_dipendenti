import { Dipendente } from "../Dipendente/dipendente";
import { Commessa } from "../Commessa/commessa";

export class Responsabile {

    id? : number;
    nom? : string;
    cog? : string;
    email? : string;
    datIni?: string;
    datFin? : string;

   dipRIF? : number[];
   comRIF? : number[];
}
