import { Component, inject, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FaIconLibrary, FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { fontAwesomeIcons } from './shared/font-awesome-icons';
import { NavigationComponent } from "./layout/navigation/navigation.component";
import { TmpComponent } from './tmp/tmp/tmp.component';
import { LibraryComponent } from './layout/library/library.component';
// import { TmpComponent } from "./tmp/tmp/tmp.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FontAwesomeModule, TmpComponent, NavigationComponent,LibraryComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
/*   schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ] */
})
export class AppComponent implements OnInit{
  ngOnInit(): void {
   this.initFontAwsome();
  }
  initFontAwsome() {
   this.faIconLibrary.addIcons(...fontAwesomeIcons);
  }
  title = 'spotify';
  private faIconLibrary = inject(FaIconLibrary);

 
  
}
