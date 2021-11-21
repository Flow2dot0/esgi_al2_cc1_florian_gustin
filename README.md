# ESGI AL2 - Florian Gustin - CC1

Created: November 21, 2021 10:50 PM

# Diagramme de classes :

![esgi_al2_cc1_florian_gustin.png](diagram.png)

# Pré-requis :

- Java 11
- Maven

# Argumentation :

J'ai choisi de séparer l'application en 3 grands modules :

- core
- multipay
- marketplace

Pour enchainer simplement mes étapes du processus d'adhésion j'ai choisis d'utiliser le pattern de la chaine de responsabilité qui me permet d'ordonner par le biais d'handler (approvers).

Pour la communication entre les modules multipay et marketplace j'ai pris l'initiative d'implémenter un pattern observer avec un seul observer dans le cas d'un paiement ou d'une autorisation de paiement et pour des raisons de sécurité, un seul observer doit écouter les changements.

J'avais commencé à un implémenter un marshaller, mais au final je n'ai pas trouvé utile dans le cadre de l'exercice de continuer car il n'y a pas réellement de communications sortantes style HTTP.

J'ai pour habitude d'utiliser des value objects et des validators, j'ai donc fait la même chose dans le cadre de l'exercice. Ils me mettent permettent de vérifier l'exactitude des données et les modifications malveillantes.

J'ai aussi intégrer plusieurs génériques afin de gagner du temps.

Pour ce qui est des tests unitaires. Par manque de temps j'ai fait ce que j'ai pu dans le délai imparti.