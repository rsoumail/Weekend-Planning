import {Principal} from '../shared/auth/principal.service';
import {Component, OnInit} from '@angular/core';
import {HttpParams, HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import 'rxjs/add/operator/map';
import {PLACE_API_URL} from './../app.constants';
import {PlaceService} from './place.service';
import {HttpModule} from '@angular/http';
@Component({
  selector: 'app-place',
  templateUrl: './place.component.html',
  styleUrls: ['./place.component.css']
})
export class PlaceComponent implements OnInit {
  currentAccount: any;
  userChoices = new Set();
  private urlCommunes: string;
  private urlDepartements: string;
  private urlRegions = PLACE_API_URL + 'regions?fields=nom,code&format=json';
  private urlInfo = PLACE_API_URL + 'communes/?fields=nom,code,codesPostaux,codeDepartement,codeRegion,population&format=json&geometry=centrexhttps://geo.api.gouv.fr/communes/?fields=nom,code,codesPostaux,codeDepartement,codeRegion,population&format=json&geometry=centre&code=';
  listRegions;
  listDepartements;
  listCommunes;
  selected = null;
  information: string = null;
  selectedRegion = null;
  selectedDep = null;
  selectedCom = null;
  params = new HttpParams();
  constructor(
    private http: HttpClient,
    private router: Router,
    private principal: Principal,
    private service: PlaceService) {}

  ngOnInit() {
    this.http.get(this.urlRegions).subscribe(data => this.listRegions = data);
    this.getId();
  }
  chargerDep() {
    //    this.params.set('code', this.selectedRegion.code);
    console.log(this.selectedRegion.code);
    this.urlDepartements = PLACE_API_URL + 'regions/'.concat(this.selectedRegion.code).concat('/departements?fields=nom,code');
    this.http.get(this.urlDepartements).subscribe(data => this.listDepartements = data);
    this.information = 'la region: '.concat(this.selectedRegion.nom);
    this.selected = this.selectedRegion;
  }

  chargerCom() {
    console.log(this.selectedDep.code);
    this.urlCommunes = PLACE_API_URL + 'departements/'.concat(this.selectedDep.code).concat('/communes?fields=nom,code');
    this.http.get(this.urlCommunes).subscribe(data => this.listCommunes = data);
    this.information = 'le departement: '.concat(this.selectedDep.nom);
    this.selected = this.selectedDep;

  }

  infoCom() {
    this.http.get(this.urlInfo.concat(this.selectedCom.code))
      .subscribe(data => console.log(data));
    this.information = 'la commune: '.concat(this.selectedCom.nom);
    this.selected = this.selectedCom;

  }

  setChoice() {
    if (this.selected != null) {
//      this.userChoices.add(this.selected);
//      console.log('pushed');
      this.selected = null;
      //this.service.updateUserPlaces();
    }
  }

  isValidForm() {
    return this.selected != null;
  }

  nextStep() {
    this.router.navigateByUrl('/mes_sports');
  }

  isEmpty() {
    return (this.userChoices.size < 1);
  }


  getId() {
    this.principal.identity(true).then((account) => {
      // After the login the language will be changed to
      // the language selected by the user during his registration
      this.currentAccount = account.id;
      console.log(account.id);
      this.getUserChoices();
    });
  }
  
  getUserChoices() {
      this.service.getUserPlaces(this.currentAccount).subscribe((response) => {
      // this.activities = data;
      console.log(response);
      // if(response.status == 200)
      this.userChoices = response;
      // else
      //   this.activities = {}
    }, (response) => {
      console.log(response);
    });;
  }
  
  updateUser() {
    
  }
}
