# Guide utilisation de git pour l'équipe du projet Pirate:


## Récupérer le projet :
git clone + le_lien_https

## Pour se déplacer dans le dépôt :

* git branch : donne la liste des branches du projet 
* git status : permet de savoir où vous vous situez ainsi que d'avoir la différence entre votre dépôt local et le dépôt distant -> donne l'état des fichiers du dépôt courant 
* git checkout <nom_branche> : permet de vous déplacer dans la branche souhaitez ; je vous conseille de faire un git status juste après histoire de voir si votre répertoire de travail est à jour par rapport au dépôt distant

## Commandes de bases au cas où:

* git add : permet d'ajouter à l'index (aussi appelé stage) un ou les fichier de votre répertoire de travail
  * .
  * -A
  * <nom_fichier>
* git commit -m "Votre message" : permet d'historiser votre index/stage dans le dépôt local (git)

* git push : permet de publier votre dernière historisation sur le dépôt distant (GitHub)
  Pour plus de sureté, on peut préciser le push (c'est la même commande pour envoyer une branche que l'on vient de créer, sur le dépôt distant ): 
    git push origin <nom_branche> (1)

* git pull : permet de récupérer le dépôt distant


## LES BRANCHES

* git branch <nom_branch> <branche_origine> : le 2ème paramètre est optionnel quand on veut créer une branche à partir de master
* git branch -m <nvx_nom> : permet de renommer une branche 
* git branch -d <nom_branch> : permet de supprimer 
* git merge <branch> : permet de merge branch dans la branche actuelle

## Sauvegarde de répertoire de travail et de l'index? -> à vérifier

* git stash : sauvegarde du répertoire de travail
* git stash list : liste de tout les stash avec leurs identifiants
* git stash apply :applique le stash le plus récent (possibilité d'ajouter l'identifiant à la fin)
* git stash pop : comme apply mais le supprime de la liste
* git stash drop <identifiant_du_drop> : supprime le stash identifié 

Bonne pratique : 
* Documenter les stash avec git stash save "message"
 

## Commandes en vrac

* git log -> permet d'avoir un listage des commit, il existe plein de paramètres différents

* git diff -> donne les différences en cours entre l'index et le répertoire

* git diff branch1..branch2 -> liste les différences entre la branche 1 et 2

* git tag <nom_tag> -> permet de créer un tag

* git push origin --tags -> envoie les tags sur le dépôt distant
* git push origin ma-branche

* git remote show origin : Vu approfondis du suivis des branches ainsi que de leur relations avec le dépôt distant 
  * Cette commande affichera des informations sur les branches du dépôt distant ainsi que les correspondances avec vos branches locales, y compris les branches de suivi pour le push et le pull.
  
* git branch -vv : Vu rapide des relations entre branches locales et distantes.
  * La branche upstream est indiquée dans les crochets, par exemple, [origin/main], où origin est le nom du dépôt distant et main est le nom de la branche distante.
  
* git push -u origin <nom_branch> ( -u == --set-upstream ):
  * permet de configurer le push afin de ne pas avoir à préciser la branche 

* git checkout -> permet de revenir au dernier commit de la branche dans laquelle on se trouve (et donc supprimer les modification)

* git reset -> comme git checkout mais en plus puissant (voir le dernier lien des ressources)

## Ressources :

Cours très simple mais bon c'est déjà ça : 
https://openclassrooms.com/fr/courses/7162856-gerez-du-code-avec-git-et-github

https://www.atlassian.com/fr/git/tutorials/using-branches/merge-conflicts

https://learn.microsoft.com/fr-fr/azure/devops/repos/git/undo?view=azure-devops&tabs=git-command-line

https://stackoverflow.com/questions/9834689/how-can-i-see-the-differences-between-two-branches

https://git-scm.com/book/fr/v2/Les-branches-avec-Git-Les-branches-en-bref#:~:text=Pour%20afficher%20toutes%20les%20branches,à%20la%20commande%20git%20log%20.&text=Cette%20commande%20a%20réalisé%20deux,du%20snapshot%20pointé%20par%20master%20.

https://www.sebastien-gandossi.fr/blog/git-supprimer-une-branche-locale-ou-distante#:~:text=Supprimer%20une%20branche%20locale%20avec%20Git,-Il%20y%20a&text=%2DD%20est%20l'abbréviation%20de%20%2D%2Ddelete%20%2D%2Dforce%20qui,a%20été%20mergé%20ou%20pas

https://geekflare.com/fr/how-to-create-a-new-git-branch/#:~:text=Si%20vous%20souhaitez%20baser%20votre,la%20branche%2C%20exécutez%20git%20log%20.&text=Vous%20pouvez%20ensuite%20basculer%20vers%20votre%20nouvelle%20branche%20en%20la%20vérifiant.

https://git-scm.com/docs/git-merge

https://stackoverflow.com/questions/18031946/when-doing-a-git-push-what-does-set-upstream-do

https://www.reflexion-graphic.com/comment-supprimer-les-changements-locaux-avec-git-que-lon-na-pas-commit#:~:text=Utilisez%20toujours%20la%20commande%20git,modifications%20que%20vous%20avez%20apport%C3%A9es.