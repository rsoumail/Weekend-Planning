import {Principal} from '../shared/auth/principal.service';
import { Activity } from './activity.model';
import {Component, OnInit} from '@angular/core';
import {ActivityService} from './activity.service';

@Component({
  selector: 'app-activity',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.css']
})
export class ActivityComponent implements OnInit {
  currentAccount: any;

  listActivities = ['surf', 'voile', 'plage', 'ski', 'wake',
    'vélo', 'course à pied'];
  activities: any;
  userActivities = new Set();
  selectedActivity = null;
  userChoices = new Set();

  constructor(private ActivityService: ActivityService,
    private principal: Principal) {}

  ngOnInit() {
    this.getId();
    this.getAllPlaces();
  }

  AddActivity() {
    this.userChoices.add(this.selectedActivity);
    this.selectedActivity = null;
  }

  isValidButton() {
    return this.selectedActivity != null;
  }

  getUserActivities(id) {
    this.ActivityService.getUserActivities(id).subscribe((response) => {
      console.log(response);
      this.userActivities = response;
    }, (response) => {
      this.userActivities = null;
      console.log(response);
    });

  }

  getId() {
    this.principal.identity(true).then((account) => {
      // After the login the language will be changed to
      // the language selected by the user during his registration
      this.currentAccount = account.id;
      this.getUserActivities(this.currentAccount);
      console.log(account.id);
    });
  }

  getAllPlaces() {
    this.ActivityService.getAll().subscribe((response) => {
      console.log(response);
      this.activities = response;
    }, (response) => {
      this.activities = {};
      console.log(response);
    });
  }
  
  
  addActivity(){
    this.ActivityService.updateUser(this.currentAccount, this.selectedActivity).subscribe((response) => {
      console.log(response);
      this.getUserActivities(this.currentAccount);
    }, (response) => {
      console.log(response);
    });
    this.selectedActivity =null;
  }

}
