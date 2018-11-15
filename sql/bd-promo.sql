select apprenant.nom, apprenant.prenom, activite.AC_NOM
from apprenant
inner join avoir
on apprenant.id = avoir.id_App
inner join activite
on activite.AC_ID = avoir.id_Act
where apprenant.prenom = 'Autrique'