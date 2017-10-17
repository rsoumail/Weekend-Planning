export class Activity{
  public name : string;
  public level: number;
  public users?: any[];

  constructor(name: string, level: number, users:any){
    this.name = name;
    this.level = level;
    this.users = users;
  }
}
