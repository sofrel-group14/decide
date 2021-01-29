# DECIDE 🚀💥
A Launch Interceptor Program written in Java.

# What it is
It is as simple as it sounds. DECIDE is a program that decides, based on input data, if it should launch an intercepting missile or not.

## Tools used

Uses Java with Maven as build system and JUnit for testing. *TODO:* Maybe add more information on versions (etc.) here.

# How to contribute

## Code

Code should follow the [Google Java Styleguide](https://google.github.io/styleguide/javaguide.html).

**Each function has to be associated with at least one test** (i.e. unit testing). See the [Testing](#testing) section for details. This is one of the mandatory grading criterias.

## Issues

Issues should be categorized using the existing labels (bug, documentation, enhancement, etc.).

They should also immediately be linked to the DECIDE project board (specifically the backlog column, i.e. the one chosen by default), so that they are visible there as well.

**IMPORTANT**: Assign yourself to an issue before you start working on it. This is to avoid having two or more people accidentally doing "double work". Make sure to coordinate with the assignee of an issue before starting to work on it yourself.

## Commits

Commit messages should always be written in an editor and not the terminal. This is to avoid the pitfall of short and non-descriptive commit messages.

```
git commit -m "Short message"       # bad
git commit                          # good
```

That said, if a short message suffices to explain the commit, that is perfectly fine.

Commit messages should be linked to corresponding issues where applicable (this is done by referencing the issue number as `#<issue number>`). Note that commits should almost always be related to some issue (see grading criteria). If there's no related issue, one should probably be created before committing.

Commit messages should follow a prefix-convention, with the following prefixes:
* feat - for new features/functionality
* fix - for bug fixes
* doc - for documentation
* refactor - for refactoring
* test - for editing or adding new tests (to already existing features, see paragraph below)
* misc - for anything not covered by prefixes above

**Note** that each commit that adds new functionality must also contain corresponding tests for that functionality (in the same commit).

**Examples:**

```
(feat) Implement LIC 7 along with corresponding unit tests, fixing #12
```

```
(test) Add additional unit test for LIC 7

This covers a previously untested edge case where X < 0. Related to #12.
```

## Branches

Branches should be linked to issues through their names, as:  
`issue-<issue number>/short-description-of-branch`

**Example:** `issue-12/lic-7` if issue 12 is related to implementing LIC 7.

(This naming convention adheres to [widely used community conventions](https://github.com/agis/git-style-guide#branches). *Disclaimer:* Some problems may appear when using slashes in branch names if using CI, see comments [here](https://stackoverflow.com/a/6065944).)

## Pull requests

*TODO: Add something reasonable here. For example, I think we decided that we need at least two people to do code review before merging. Also we should probably start branching from 'development' and then merging into that, as discussed in our last meeting.*

# Testing

*TODO:* Add more information here. One important piece to remeber is that tests should be accompanied by a "description in natural language". Also, it's probably worth mentioning here as well that functionality and corresponding tests should be added in the same commit.

# Statement of contribution
*TODO:* Fill in one/two paragraphs "stating the respective contributions of each group member". This is also where to add a note if we do something "extraordinary" worthy of P+.