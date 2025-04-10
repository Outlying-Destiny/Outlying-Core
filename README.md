# Description
A collection of tweaks for the Outlying Destiny modpack.<br/>
<br/>
Outlying Core features mod-tweaks and fixes for the pack, while keeping most things easily editable thanks to the use of configs and resourcepacks.<br/>
You are free to use it at your own risk.

# Changes
All of the following features can be enabled/disabled or tweaked using the config files:
 - Ender IO:
    - Machines:
       - Allows linear scaling of machines' energy capacity (instead of quadratically) based on the Capacitor's base modifier value 
       - Allows linear scaling of machines' energy usage rate (instead of quadratically) based on the Capacitor's base modifier value
       - These changes can be useful for gating machines more precisely during progression (e.g. if the linear energy usage rate is enabled, recipes' energy cost can be set in a way that machines with lower-tier Capacitors aren't terribly slow and with higher-tier Capacitors aren't incredibly fast)
    - Capacitors:
       - Adds configurable base modifier values for Capacitors
 - Iron Jetpacks:
    - Allows the use of a custom texture for each Jetpack tier instead of using tints (path for each texture: ironjetpacks/textures/models/armor/jetpack_id.png)