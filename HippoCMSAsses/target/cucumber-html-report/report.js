$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CreateDocument.feature");
formatter.feature({
  "line": 1,
  "name": "Create and Publish News document",
  "description": "Description: Verify user is able to create a new document and publish it to website",
  "id": "create-and-publish-news-document",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2107810073,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "user already logged in to Hippo",
  "keyword": "Given "
});
formatter.match({
  "location": "dashboardPage.user_already_logged_in_to_Hippo()"
});
formatter.result({
  "duration": 1957334564,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Succesfully Navigating to Create Document Page",
  "description": "",
  "id": "create-and-publish-news-document;succesfully-navigating-to-create-document-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "user in dashboard page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "the user clicks create a News Document",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "then user enters all the valid data and saves the document",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "publishes the document",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the data should be published to website",
  "keyword": "Then "
});
formatter.match({
  "location": "dashboardPage.user_wants_to_publish_data_to_website()"
});
formatter.result({
  "duration": 3920092114,
  "status": "passed"
});
formatter.match({
  "location": "dashboardPage.the_user_clicks_create_a_News_Document()"
});
formatter.result({
  "duration": 110051341,
  "status": "passed"
});
formatter.match({
  "location": "dashboardPage.then_user_enters_all_the_valid_data_and_saves_the_document()"
});
formatter.result({
  "duration": 4602662684,
  "status": "passed"
});
formatter.match({
  "location": "dashboardPage.publishes_the_document()"
});
formatter.result({
  "duration": 1817621018,
  "status": "passed"
});
formatter.match({
  "location": "dashboardPage.the_data_should_be_published_to_website()"
});
formatter.result({
  "duration": 6073103494,
  "status": "passed"
});
formatter.after({
  "duration": 4973383805,
  "status": "passed"
});
});