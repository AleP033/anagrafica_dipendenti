import { Commessa } from "../Commessa/commessa";
import { Dipendente } from "../Dipendente/dipendente";

export class Timesheet {

    id? : number;
    oreLavorate? : number;
    dat? : string;
    tipologia? : string;

    dipRIF? : number;
    comRIF? : number;
}
