Pill Reminder
===

The Goal:
---
Pill Reminder is an native android application meant to aid the forgetful and busy with remembering to take their daily medications. It is designed for users who need a little help keeping track of their medication schedule and who are dedicated to keeping the schedule. It is not designed for people who wish to cheat the system or plan to not stay up-to-date with the schedule. The application allows the user to store pill objects and multiple alarms for those pills. Alarms have one time of day and can occur on multiple days of the week. The user is able to view their pills in a today view, a tomorrow view, a weekly view, and an editable view that shows every pill and every alarm. In addition, the application stores the history of when each medication was taken; this will aid the user in keeping track of their medication usage.

How to get it working:
---
- Download ZIP from GitHub
- Download Android Studio and SDK Android 5.0.1 API 21 (the minimum API Level required for the application to run is API 16)
- SDK Build Tools 21.1.2
- It is not recommended for phones with resolution smaller than 480x800
- Please use at your own risk for APIs newer than API 21 and older than API 16
- It is highly recommended for users to use the Genymotion Android emulator over the built in Android Studio emulator (https://www.genymotion.com)

Known Bugs and Future Plans:
---
See GitHub issues. (https://github.com/Qitalach/PillApp/issues)

What each buttons do:
---
In the Home page, you will see 3 buttons in the top right of the application.
######Plus sign: 
This will take you to the Add Activity where you will be able to create an alarm. The application will automatically link up all the alarms to a specific pill with the same Pill Name. If you attempt to create an alarm to a pill that does not exist, it will automatically create a pill object for you.
######Suitcase sign: 
This will take you to the Pill Box Activity where you will be able to see all the pills and alarms created. This will also be the place where you can edit and delete any pill and alarm you desire.
######Calendar sign: 
This will take you to the Schedule Activity where you can see all the pills and alarms organized by the day of week.

Attributions:
---
- We use the icon designed by MedicalWP and obtained from IconArchive.com (http://www.iconarchive.com/show/medical-icons-by-medicalwp/Pills-blue-icon.html). We use the Android Launcher Icon Generator (https://romannurik.github.io/AndroidAssetStudio/icons-launcher.html) to generator the icon image files and save them in the res/mipmap folder.
- Some fonts are Roboto fonts designed by Google. We store all the Roboto fonts (including those we never u in the assets/fonts folder. We get all the font filesfrom Google at http://developer.android.com/design/style/typography.html.
- We use the Android Action Bar Style Generator created by Jeff Gilfelt (http://jgilfelt.github.io/android-actionbarstylegenerator/) to generate the theme of our action bar. Themes are saved in style.xml in the res/values folder. All the image files associated with the themes are saved in the res/drawable folder. 
- We use the Android Action Bar and Tab Icon Generator (https://romannurik.github.io/AndroidAssetStudio/icons-actionbar.html) to generator the action bar icons. All the related image files are saved in the res/drawable folder. 
- We store the hex codes of all the light blue colors from Google’s color palette (http://www.google.com/design/spec/style/color.html) in colors.xml in the res/values folder. 
- We use the codes from a couple of tutorials online as our templates. We include their links in the comments in the files that utilize them. See more details in files in the java folder.
