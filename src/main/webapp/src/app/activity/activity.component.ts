import {Component, OnInit} from '@angular/core';
import { ActivityService } from './activity.service'

@Component({
  selector: 'app-activity',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.css']
})
export class ActivityComponent implements OnInit {

  listActivities = ['surf', 'voile', 'plage', 'ski', 'wake',
     'vélo', 'course à pied'];
  activities: any;
  selectedActivity = null;
  userChoices = new Set();

  constructor(private ActivityService: ActivityService) {}

  ngOnInit() {
     this.ActivityService.getAll().subscribe((response)=> {
       //this.activities = data;
       console.log(response);
      // if(response.status == 200)
          this.activities = response;
      // else
      //   this.activities = {}
     }, (response) => {
       this.activities = {};
       console.log(response);
     });
  }

  AddActivity() {
    this.userChoices.add(this.selectedActivity);
    this.selectedActivity = null;
  }

  isValidButton() {
    return this.selectedActivity != null;
  }

}
