import {Categorie} from "./categorie";

export class Projet {

  constructor(public id: number,
              public nom: string,
              public dateFin: Date,
              public montant: number,
              public image: string,
              public description: string,
              public entrepreneuse: string,
              public statut: string,
              public categorieId: number,
              public typesContributions: number[],
              public montantRecolte: number) { }
}
