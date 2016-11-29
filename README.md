**HUNTARD**
## Coders for Harambe Devs.

CSC 4350 (Software Engineering)

Fall 2016

Hunter Stanley, Robert Batson, Chase Randall, James O'Leary, Jeffrey Kim

<!---
### Aug. 30, 2016
JK: I completed WSD chart, introduction assignment 1 and team contract. 
  Will have team meeting pretty soon hopefully to discussion our project planning/ blueprint.
  I will be frequently updating this README document with all our of plans/ "milestones"/ bugs/ debugs

### Sep. 6 2016: Team met and discussed 
*the general idea of the project
*assigned roles for documentation 2
#dead-line: Sept. 15 2016 for documentation 2

### Sep. 8 2016 -- Documentations 2: Requirements Elicitations 
  Hunter: 2 -- Problem statements using "shall" statements
  Jeffrey: 1, 4, 6, 7 -- COVER PAGE, Update WSD, dictionary explaining terms, rationale for the topic chosen
  Robert: 3 -- RTM
  Chase: 5 -- Gantt Chart
  James: pesudo code, and putting Documentation 2 or 3 (IDK)

### Sep. 12, 2016 -- Pseudo code uploaded 
  James uploaded the Pseudo code
  
### Sep. 13 2016 3:35PM -- added infos. 
  Jeffrey completed WSD chart 
  Chase completed Gantt Chart 
  Hunter completed problem statements 
  James completed pseudo code 
  Robert will #complete RTM chart 
  
### Sep. 14 2016 9:49 AM 
  Completed all requirements besides: dictionary and rational topic for shall statement problems.
  
### Sep. 19 2:21PM -- Document 2 is completed. 
  Bhola assigned document 3. 
  
### Sept. 22, 2016 4:05Pm -- Prototype presentations. 
- Start on documention 3.
- Hunter is project coordinator
  
### Sept. 26 2016 1:45PM 
- creating documentation 3 
- Due date: this thursday
 
### Sept. 27, 2016 10:34AM 
  -Deciding on the roles assigning to each member
  **Hunter is the project coordinator. **
#DEADLINE: Documentation 3: Sept. 29, 2016
#### Documentation 3
  1. Title page
  2. Horizontal prototype 
  3. RTM - first 5 columns and all other updates
  4. Use cases and Interaction Diagram - example as per given in class
  5. Function Point Cost Analysis
  6. Database to be used
  7. Updated WSD 
  8. Updated Gantt Chart
  9. Dictionary explaining shit jargon
  10. A rational for the use cases, etc
  
# Use Case: 2:26PM
- [ x ] Jeffrey Kim: Hunting Mini-Game, BaseDefense, Scavenging 
- [ x ] Robert Batson: Start screen, Items, Hunting
- [ x ] Huntard: Mentality, Updates, Radio
- [ x ] James O'Leary: Food & Water, Scavenging & Hunting, Scavenging Mini-Game
- [ x ] Chase: Winning Game, Night Activities, Daily Decision
- Functional Point Cost Analysis open

### document 3 complete bitch


## Document 4 1:56PM -- Object design
- Character: James
- Items:  Hunter  
-  Gun    Hunter
-  Map    Hunter
-  Food   Robert  
-  Water  Robert
-  Med Kit   Jeffrey
- Mini-Game: Chase
-  Hunting    Chase
-  Scavenging Chase
- DailyDecisions: Jeffrey
- Huntardgame: James

### Completed class design
## D0cument 4 - 
- Chase: 4
- James: 9
- Huntard: 3, 6
- Jeffrey: 1,7, 8 
- Robert: 4

# Document 5: 12:54PM (Oct. 11, 2016)
- Title page
- TAKE ALL RATIONALE AND PUT IN ONE DOCUMENT
- Update RTM
- Update WSD
- update Gantt Chart
- Dictionary

# Document 6: 1:49PM
- Title page: ROBERT
- RTM: HUNTER
- Source Code on disk: ROBERT
- Test cases used to test software: EACH PERSON
- COCOMO: CHASE
- Update WSD: JEFF
- Update Gantt Chart: JEFF
- Dictionary: NONE
- Rationale for test cases and type used: JAMES & ROBERT
- One test case per person (=5)
--->

### DOCUMENT STUFF
1. Use cases/Sequence diagram- Almost all of the use cases need to be redone, use the one we had on the presentation as a model, we were one of the groups that he said the least about in terms of those. Other than that database thing which is kinda stupid but we need to include it anyways

2. Rationale for topic chosen- On the document he just said no to this. Then he wrote that it should be a rationale for the functionalities/requirements, so this needs to be redone

3. Rationale for sequence diagrams- Apparently this was just never done. So it needs to be.

4. Class Objects- Many of the class objects are incorrectly labeled/named and some extend classes that don't even exist, so they need to be changed, this one won't be much work at all.

5. Test cases- We just need to make sure these all use the same formatting. It looks weird when theyre all slightly different

6. Add the things to COCOMO- just needs those options that were picked added to them

7. Requirements Elicitation- since we changed the RTM we need to change this as well. Just start a new document and paste the contents of the RTM into it

8. RTM/Use case #'s- We need the number of the use case to correspond with the RTM number. So we need just need to change the numbers in both the RTM and the use cases

9. Category Interaction Diagram- Acutally I think this was already done but it needs a GUI category

10. Cost Analysis Comparisons/Conclusion- we need to write a comparison and conclusion for the cost analysis

11. Project Legacy- This is kind of like an analysis of what we did right and wrong and what we would change. I'm not sure about the format though, Chase you emailed Bhola about this right? What did he say?

12. Resumes- Have them ready, we need to make sure the format doesn't get fucked up so put them in a PDF

13. User guide- How's that coming Chase? Do we have a format giving given from Bhola?

SOFTWARE----------------------
1. Radio- This one won't be difficult in terms of GUI, I'm thinking make an array with different things to say about situations and then shuffle it based on a key and you can use the key to determine the index's location in the original array and pass that info to the Hunting/Scavengin game where they'll use it to determine the amount of enemies/gorillas and loot

2. Defence- Setting it so that every night has a person that goes on guard or at least has the option to. This won't be difficult in terms of logic, just a boolean to see if its being guarded and if it is get the stats of the player and the stats of the gun. Also random generation of attacks on the base in terms of if it happens at all and the intensity of the attack. Also if a player is on guard then he doesn't get sleep, which brings me to the next one.

3. Sleep- If a player doesn't get sleep their psychology decreases. I'm thinking that the factory by which it will decrease will be some variable multiplied by (4 - the psychology stat) so that lower psychology stats decrease by a higher amount. If a player is put on guard or goes out hunting/scavenging then they wont sleep.

4. Talk to character functionality- Increasing the psychology by talking to the character. This can just be a button on the character screen which brings up a window to choose with whom to talk to the character. Logic should be easy too, just add their psychology values and divide it by two to get the new value. When I told this to Jeff he suggested doing the same thing to the character talking to the other thus decreasing his/her value as well, which is a possibility

5. Map- a place where you can choose the location to go to. I'm not sure what Hunting/Scavenging want to do about different maps. Different backgrounds at the very least but I'd like it if there was a bit more variation than that. Also you need to take into account what the radio says about that specific location. Anyways for GUI I was thinking putting a Picture of one of the old timey looking maps with the rolled edges and having little buttons placed on different parts of it that look like pins with labels on them. Logic won't be too hard. Just pass a numerical value to tell which location it is. And check to make sure they even have a map before opening it.

6. Medkit- Just a button to increase health through medkit. Only make it clickable if player has a medkit. Increase health by some value, maybe 50? but don't let it go over 100. just add it and do if(health > 100) health = 100;

7. Special Character attributes?- Not sure if we're doing this only because I can't think of any attributes other than Healer. We'll do it if we can get some ideas

8. Stat checking- we need to check hunger/thirst/psychology/health every day and night to determine if player dies, then show some notification that the player has died

9. Hunting/Scavenging games- How're these coming along Chase/James? We're counting on you guys to beef up our # of lines of code

10. Saving/Loading- Robert said he'd take care of this. The way I'm doing decisions is that I'm going to shuffle it based on a key, just save the key and the day a number and I'll worry about interpreting it. You need to save a lot of information, the players and all their state values(Hunger/Thirst etc). You can save their strength and stuff too or you could just save their name and if their name == some name then those values. That seems like it'd be cleaner but its up to you. also Items and what not, probably missing some stuff But you'll figure it out.

11. Decisions- I'll have to take care of this since I made the process a bit complicated, but it'd be great if you guys could help me out with situation ideas

I think that's all. If anyone knows of some other things then tell me. We need to decide who will do what and get started RIGHT AWAY


