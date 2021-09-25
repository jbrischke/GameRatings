# Application Flow


### User Sign up

1. User chooses sign up on the menu (available on all pages, unless the user
   is signed in already).
1. User fills out the sign up form and submits.
1. Request goes to sign up servlet.
1. Servlet creates a user object and then creates user in the database.
1. Response to user confirming addition (show a message on the jsp)

### User Sign In

1. User chooses sign in on the menu (available on all pages, unless the user
   is signed in already).
1. User enters username and password on form and submits.
1. If user is authenticated, the server will handle allowing access to edit
   pages.  JDBCRealm used for authentication (users, users_roles, and roles table).
1. If authentication fails, show error message/page.

### View Game Report

1. Page sends a request to view games reports servlet along with criteria
   (all, by reports, release date, name, type).
1. Servlet uses the gamesReport dao to select reports according to criteria
1. Dao performs select and creates report objects from results.
1. Dao returns list of report matching criteria to servlet.
1. Servlet sends list back to game reports jsp.
1. Game reports jsp displays the reports.
1. Consider paging results so page does not get super long and too much data
   is sent.

### View Game

1. Page sends a request to view game servlet along with criteria
   (all, name, release date).
1. Servlet uses the report dao to select trails according to criteria
1. Dao performs select and creates game objects from results.
1. Dao returns list of games matching criteria to servlet.
1. Servlet sends list back to gameReports  jsp.
1. Game reports jsp displays the Reports.

### About

1. Static page - html
1. Displays admin contacts by email
1. Displays login/signup
1. Allows user to search for any game

### Add Game Report
1. Option only available to logged in users with proper role
1. User selects the Game to report on
1. User enters Game report details
1. Details are sent to Add Game Report servlet
1. Servlet creates Game report object
1. Servlet sends object to dao
1. Dao adds report to the database
1. Servlet sends confirmation to report page that report has been added.

### Add Game Suggestion
1. Option only available to logged in users with proper role
1. User enters Game details
1. Details are sent to an admin request location
1. Admin decides if its accurate and can create the new game object
1. Servlet sends object to dao
1. Dao adds Game to the database
1. Servlet sends confirmation to admin page that Game has been added.