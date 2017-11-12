export class Placemodel {
  public id: number;
  public name : String;
  public nom : String;
  public code :number;
  constructor(id:number, name:String, nom:String, code:number){
    this.id = id;
    this.name = name;
    this.nom = nom;
    this.code = code;
  }
}