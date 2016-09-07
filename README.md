
# [CodePath Android Pre-work: Todo App](http://courses.codepath.com/snippets/intro_to_android/prework)

The pre-work incorporates a few steps:

1. Setup your Android environment
2. Build initial todo app
3. Add edit functionality to todo app
4. Submit todo app for review via Github
5. Extend your todo app, improve UI, add features

## 1. Setup Android

First, you need to setup the full Android environment including Android Studio. Follow the [setup slides here](https://docs.google.com/a/thecodepath.com/presentation/d/1iD0sMc-qIG80yZ1AQfDU5nxSAl3Xe4nx-2W_g9yzMSM/edit#slide=id.p) or the [Android Studio setup video](https://vimeo.com/113893631).

To get started, we recommend you to watch the [First app video tutorial](https://vimeo.com/113893630) which introduces the Android environment and walks you through building a very simple app step-by-step. Note that this video is intended for people that have literally **never built an Android app** before. If you have any experience with Android, you might want to skim the video instead as a review of concepts you already understand.

**Running into problems?** See the [troubleshooting gist](#heading-troubleshooting-notes) below if you are running into any issues during setup.

## 2. Creating the Todo App

Now you need to develop an Android Todo list application starting by following these [walkthrough todo slides](https://docs.google.com/a/thecodepath.com/presentation/d/15JnmfmFa0hJOEkBhG_TeymChLzDzpOTJvBlOj29A9fY/edit) or by watching [this walkthrough video tutorial](https://vimeo.com/72475810). After completing the first version by following these steps, you must augment the todo app to support **editing todo items** in the list (see conceptual guide below for details). A walkthrough of the completed app can be found below:

<img src="http://i.imgur.com/b3CctIh.gif" width="300" />

**When generating the project**, you should set minSDKVersion to **API 16** and **select "Empty Activity"** in the project generator wizard.

<img src="http://i.imgur.com/TY73tPN.png" height="325" />&nbsp;
<img src="http://i.imgur.com/C3KkwI3.png" height="325" />

**Want to enable virtual keyboard?** In the GIF above, there is a virtual or "soft" keyboard. See [this guide](http://guides.codepath.com/android/Working-with-the-Soft-Keyboard) for details on how to enable.

**Running into problems?** See the [troubleshooting gist](#heading-troubleshooting-notes) below if you are running into any issues at all during setup!

## 3. Adding an Edit Feature

Assuming we've built the Todo app as explained in the [Quickstart Slides](https://docs.google.com/a/thecodepath.com/presentation/d/1iD0sMc-qIG80yZ1AQfDU5nxSAl3Xe4nx-2W_g9yzMSM/edit#slide=id.p), our app can currently only add and delete todo items from the list. Next, we need to allow users to **edit the text of an item added to the list**. This is a conceptual guide to implementing that functionality step-by-step.

<img src="http://i.imgur.com/dlnF4MJ.png" width="300" />&nbsp;
<img src="http://i.imgur.com/WJJh1HD.png" width="300" />

For this task, we want to allow the user to **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.

### Conceptual Overview

1. **Generate Second Screen** - Generate a new UI screen (activity) that we will use for the edit screen. Let's generate a second activity to be used as an edit form for an item. Generate the second activity by selecting `File => New => Activity => Blank Activity` and go through the wizard to generate the blank activity. Give the activity a descriptive name i.e `EditItemActivity`
2. **Layout Edit Form** - Let's setup the view for the EditItemActivity by going to `res/layout/activity_edit_item.xml`. Here, using the graphical editor, we need to add a multi-line text field for the item body and a save button to submit the updated text value.
3. **Support Edit Action** - Within the main activity, setup a click listener such that when I click (rather than long-click) on any item, I am taken to the Edit form screen for that item. In the click listener for the items, you need to bring up the edit form activity using an "Intent" as explained in [the CodePath cliffnotes](http://guides.codepath.com/android/Using-Intents-to-Create-Flows). To properly load the form data, you should pass along the text and position of that item to the second activity using "extras" as explained in the guide.
4. **Populate Edit Form** - Now when the user clicks an item, it should bring up the Edit form activity and the item body should be passed along to that activity within the intent. Pull out the todo item's body from the extras as explained in [the CodePath cliffnotes](http://guides.codepath.com/android/Using-Intents-to-Create-Flows#passing-data-to-launched-activities) and set the form text field to contain the item's initial value. Be sure the user's cursor in the text field is at the end of the current text value and is in focus by default.
5. **Send Back Result on Save** - We need to hook up the edit form to send the result back to the initial activity after the "Save" button is clicked. Hook up a click handler on the "Save" button on the edit form and [send back the todo item data](http://guides.codepath.com/android/Using-Intents-to-Create-Flows#returning-data-result-to-parent-activity) to the list activity. **Hint:** Be sure to review each step of this section and call `startActivityForResult` initially to launch form and then later `finish` to return the result to the original activity.
6. **Update Todo Item** - In the original todolist activity, handle the submitted form's result from the edit form by inserting the updated todo text for the item at the correct position in the array and "notify" the adapter such that the todo list properly reflects the change. **Hint:** Make sure to persist the updated text back to the file with `writeItems`.

## 4. Submitting the Project

Once you have completed the ToDo application **including support for editing an item**, please [push your app via Github](https://help.github.com/articles/create-a-repo). All submissions occur via Github and we require each submission to follow a particular format which includes a **clearly documented README** with a GIF walkthrough.

### Creating the README

Use [this README template](http://courses.codepath.com/snippets/intro_to_android/readme_templates/prework_readme.md?raw=true) for your completed ToDo app. Copy that template into your project repo in a file named `README.md`.

Be sure to include a GIF (or video walkthrough) using [LiceCap](http://www.cockos.com/licecap/) of the app demonstrating how it works with required and any optional user stories completed. See [this README](https://github.com/codepath/android-rottentomatoes-demo/blob/submission/README.md) as an example of a complete README.

### Updating Your Application

Once you have **completed all required user stories and added a README as described above** then you are ready to notify us that you are ready for a pre-work review. To do this, go to the [application status dashboard](https://apply.codepath.com/dashboard/) and then press the "SUBMIT" button in the pre-work section:

<a href="https://apply.codepath.com/dashboard/"><img src="http://i.imgur.com/ShN1oBR.png" width="500" /></a>

Make sure that this is the correct cohort before submitting. In the page that appears, enter the required information about your project:

<img src="http://i.imgur.com/VOz05yi.png" width="500" />

Then press "Submit" at the bottom to push your submission. Note that **you can always update your submission at any time** in case you want to re-upload the GIF or update the hours spent.

**Note:** All project code should be stored on github. If needed, review how to push your apps to github with [this handy tutorial](https://help.github.com/articles/create-a-repo). You should add a [.gitignore](https://gist.githubusercontent.com/nesquena/5617544/raw/.gitignore) to your project as well to **avoid storing compiled and local files in git**.

**Windows Users:** For LiceCap to record GIFs properly in certain versions of Windows, be sure to set Scaling to 100%.

### Submission Checklist

Please **review the following checklist** to ensure your submission is valid:

 * Can you **successfully add and remove items** from the todo list within your app?
 * Did you include support for **editing todo items** as described above?
 * Does your app **persist todo items** and retrieve them properly on app restart?
 * Did you successfully **push your code to github**? Can you see the code on github?
 * Did you **add a README.md** to the repo on github which includes a **GIF walkthrough** of the app's functionality?
 * Did you visit your application and **submit using the pre-work form**?

If the answer to all of these is **YES** then you've successfully completed the basic todo app. When you've completed this, we will schedule a short phone call with you so we can chat further and answer any questions you have about the bootcamp and the rest of the selection process. In the meantime, you should focus on **improving the functionality and user interface** of your Todo app as outlined below.

## 5. Extending Your Todo

After initial submission, you should iterate by adding several additional features to your todo app. Engineers that submit Todo apps with extended functionality and improved UI are **significantly more likely to be accepted** into the bootcamp. Be sure to refer to our [comprehensive guides](http://guides.codepath.com/android). Try your hand at implementing the following user stories and any other extensions of your own choosing:

 * **(Suggested)** Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
 * **(Suggested)** Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
 * **(Suggested)** Add support for completion due dates for todo items (and display within listview item)
 * **(Suggested)** Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
 * Add support for selecting the priority of each todo item (and display in listview item)
 * Tweak the style improving the UI / UX, play with colors, images or backgrounds
 * Anything else that you can get done to improve the app functionality or user experience!

In addition to adding features and polish, be sure to **improve the organization of your code** and meet Android style guidelines by review our guide on how to [organize your Android app files and folders](http://guides.codepath.com/android/Organizing-your-Source-Files).

Please **reply back to the github issue** after pushing new features. Be sure to include in the README an updated GIF walkthrough using [LiceCap](http://www.cockos.com/licecap/) of the app demoing how it works with required user stories completed.

# Excellent Past Submission

See the below submission for an example of an excellent past submission. It only takes 1-2 hours to implement the basic version, but you should spend more time exploring the Android framework.

  <a href="/course_images/intro_to_android/listly.gif" target="_blank"><img src='/course_images/intro_to_android/listly.gif' title='imgur' width='300' alt='imgur' /></a>

# Troubleshooting Notes

During setup, there are a number of ways that things can go wrong and this can be very frustrating. This is an attempt to help you avoid common issues as much as possible.

To develop modern Android apps, you should probably use Android Studio. Follow the [Android Studio setup slides here](https://docs.google.com/a/thecodepath.com/presentation/d/1iD0sMc-qIG80yZ1AQfDU5nxSAl3Xe4nx-2W_g9yzMSM/edit#slide=id.p) or the [Android Studio setup video](https://vimeo.com/113893631).

## General Troubleshooting

A few important troubleshooting tips are below:

1. **Hello World app doesn't run** - If the "Hello World" app that you loaded during setup doesn't run for any reason, you can skip that step and move directly to the todo app which will have you generated new project.

2. **Generating New Project** - Be sure to select minSDKVersion to **API 16** and **select "Empty Activity"** in the new project wizard.

3. **Emulator Booting** - Make sure to install HAXM and setup the HAXM emulator if you are on an intel-based machine as explained in the slides. Also on Android, make sure to **boot up the emulator first** through the Virtual Device Manager and verify that the virtual device is running properly **before attempting to run the app**. Also, do not close the emulator each time you want to run the app. **Leave the emulator open** and when you run the app will be re-installed onto the existing virtual device.

4. **Issues with Git?** Check out our [collaborating with Git guide](http://guides.codepath.com/android/Collaborating-on-Projects-with-Git) for an overview of the basic git workflow on the command line or find a [nice GIT desktop client](https://git-scm.com/downloads/guis) to make working with Git even easier.
