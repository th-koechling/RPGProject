package view;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by thorsten on 25.07.16.
 *
 * Contains the images used for the visual representation of
 * the dungeon area, monsters, equipment and treasure items in the GUI map.
 *
 */
public class Pictures {

    // Dungeon environment
    public static final Image corridor = new Image("/view/images/dungeon/corridor.png");
    public static final Image crystal_wall = new Image("/view/images/dungeon/crystal_wall.png");
    public static final Image deep_water = new Image("/view/images/dungeon/deep_water.png");
    public static final Image dngn_enter_abyss = new Image("/view/images/dungeon/dngn_enter_abyss.png");
    public static final Image dngn_entrance = new Image("/view/images/dungeon/dngn_entrance.png");
    public static final Image floor = new Image("/view/images/dungeon/floor.png");
    public static final Image floor_lair = new Image("/view/images/dungeon/floor_lair.png");
    public static final Image floor_light = new Image("/view/images/dungeon/floor_light.png");
    public static final Image floor_room = new Image("/view/images/dungeon/floor_of_a_room.png");
    public static final Image floor_swamp = new Image("/view/images/dungeon/floor_swamp.png");
    public static final Image ice = new Image("/view/images/dungeon/ice.png");
    public static final Image lava = new Image("/view/images/dungeon/lava.png");
    public static final Image lit_corridor = new Image("/view/images/dungeon/lit_corridor.png");
    public static final Image altar = new Image("/view/images/dungeon/misc_altar.png");
    public static final Image molten_lava = new Image("/view/images/dungeon/molten_lava.png");
    public static final Image throne = new Image("/view/images/dungeon/opulent_throne.png");
    public static final Image raised_drawbridge_h = new Image("/view/images/dungeon/raised_drawbridge_h.png");
    public static final Image raised_drawbridge_v = new Image("/view/images/dungeon/raised_drawbridge_v.png");
    public static final Image rock_wall01 = new Image("/view/images/dungeon/rock_wall01.png");
    public static final Image rock_wall05 = new Image("/view/images/dungeon/rock_wall05.png");
    public static final Image rock_wall07 = new Image("/view/images/dungeon/rock_wall07.png");
    public static final Image rock_wall09 = new Image("/view/images/dungeon/rock_wall09.png");
    public static final Image rock_wall10 = new Image("/view/images/dungeon/rock_wall10.png");
    public static final Image rock_wall14 = new Image("/view/images/dungeon/rock_wall14.png");
    public static final Image rock_wall15 = new Image("/view/images/dungeon/rock_wall15.png");
    public static final Image shallow_water = new Image("/view/images/dungeon/shallow_water.png");
    public static final Image spiked_pit = new Image("/view/images/dungeon/spiked_pit.png");
    public static final Image stone_arch = new Image("/view/images/dungeon/stone_arch.png");
    public static final Image tree = new Image("/view/images/dungeon/tree.png");
    public static final Image web = new Image("/view/images/dungeon/web.png");

    public static final String[] dungeonNames = {"corridor", "crystal_wall", "deep_water", "dngn_enter_abyss", "dngn_entrance", "floor", "floor_lair",
            "floor_light", "floor_room", "floor_swamp", "ice", "lava", "lit_corridor", "altar", "molten_lava", "throne",
            "raised_drawbridge_h", "raised_drawbridge_v", "rock_wall01", "rock_wall05", "rock_wall07", "rock_wall09", "rock_wall10",
            "rock_wall14", "rock_wall15", "shallow_water", "spiked_pit", "stone_arch", "tree", "web"};

    public static final Image[] dungeonPics = {corridor, crystal_wall, deep_water, dngn_enter_abyss, dngn_entrance, floor, floor_lair, floor_light,
            floor_room, floor_swamp, ice, lava, lit_corridor, altar, molten_lava, throne, raised_drawbridge_h, raised_drawbridge_v,
            rock_wall01, rock_wall05, rock_wall07, rock_wall09, rock_wall10, rock_wall14, rock_wall15, shallow_water, spiked_pit,
            stone_arch, tree, web};

    // enemies, monsters, NPCs
    public static final Image ancient_lich = new Image("view/images/monsters/ancient_lich.png");
    public static final Image antaeus = new Image("view/images/monsters/antaeus.png");
    public static final Image asmodeus = new Image("view/images/monsters/asmodeus.png");
    public static final Image asmodeus_new = new Image("view/images/monsters/asmodeus_new.png");
    public static final Image baby_purple_worm = new Image("view/images/monsters/baby_purple_worm.png");
    public static final Image balrug = new Image("view/images/monsters/balrug.png");
    public static final Image beholder = new Image("view/images/monsters/beholder.png");
    public static final Image black_dragon = new Image("view/images/monsters/black_dragon.png");
    public static final Image black_naga = new Image("view/images/monsters/black_naga.png");
    public static final Image blue_death = new Image("view/images/monsters/blue_death.png");
    public static final Image bone_devil = new Image("view/images/monsters/bone_devil.png");
    public static final Image cacodemon = new Image("view/images/monsters/cacodemon.png");
    public static final Image carnivorous_ape = new Image("view/images/monsters/carnivorous_ape.png");
    public static final Image cave_spider = new Image("view/images/monsters/cave_spider.png");
    public static final Image centipede = new Image("view/images/monsters/centipede.png");
    public static final Image cerebov = new Image("view/images/monsters/cerebov.png");
    public static final Image cyclops = new Image("view/images/monsters/cyclops.png");
    public static final Image deep_elf_death_mage = new Image("view/images/monsters/deep_elf_death_mage.png");
    public static final Image deep_elf_fighter = new Image("view/images/monsters/deep_elf_fighter.png");
    public static final Image dispater = new Image("view/images/monsters/dispater.png");
    public static final Image dragon = new Image("view/images/monsters/dragon.png");
    public static final Image dwarf_king = new Image("view/images/monsters/dwarf_king.png");
    public static final Image dwarf_lord = new Image("view/images/monsters/dwarf_lord.png");
    public static final Image efreet = new Image("view/images/monsters/efreet.png");
    public static final Image ereshkigal = new Image("view/images/monsters/ereshkigal.png");
    public static final Image ettin = new Image("view/images/monsters/ettin.png");
    public static final Image ettin_new = new Image("view/images/monsters/ettin_new.png");
    public static final Image executioner = new Image("view/images/monsters/executioner.png");
    public static final Image eye_of_devastation = new Image("view/images/monsters/eye_of_devastation.png");
    public static final Image fiend = new Image("view/images/monsters/fiend.png");
    public static final Image fire_giant = new Image("view/images/monsters/fire_giant.png");
    public static final Image flying_skull = new Image("view/images/monsters/flying_skull.png");
    public static final Image frost_giant = new Image("view/images/monsters/frost_giant.png");
    public static final Image gargoyle = new Image("view/images/monsters/gargoyle.png");
    public static final Image geryon = new Image("view/images/monsters/geryon.png");
    public static final Image ghoul = new Image("view/images/monsters/ghoul.png");
    public static final Image giant_spider = new Image("view/images/monsters/giant_spider.png");
    public static final Image gloorx_vloq = new Image("view/images/monsters/gloorx_vloq.png");
    public static final Image gnome_king = new Image("view/images/monsters/gnome_king.png");
    public static final Image gnomish_wizard = new Image("view/images/monsters/gnomish_wizard.png");
    public static final Image golden_dragon = new Image("view/images/monsters/golden_dragon.png");
    public static final Image gremlin = new Image("view/images/monsters/gremlin.png");
    public static final Image hill_giant = new Image("view/images/monsters/hill_giant.png");
    public static final Image homunculus = new Image("view/images/monsters/homunculus.png");
    public static final Image hydra = new Image("view/images/monsters/hydra.png");
    public static final Image ice_fiend = new Image("view/images/monsters/ice_fiend.png");
    public static final Image imp = new Image("view/images/monsters/imp.png");
    public static final Image incubus = new Image("view/images/monsters/incubus.png");
    public static final Image iron_dragon = new Image("view/images/monsters/iron_dragon.png");
    public static final Image iron_troll = new Image("view/images/monsters/iron_troll.png");
    public static final Image killer_bee = new Image("view/images/monsters/killer_bee.png");
    public static final Image leprechaun = new Image("view/images/monsters/leprechaun.png");
    public static final Image lich = new Image("view/images/monsters/lich.png");
    public static final Image lich_old = new Image("view/images/monsters/lich_old.png");
    public static final Image lom_lobon = new Image("view/images/monsters/lom_lobon.png");
    public static final Image manes = new Image("view/images/monsters/manes.png");
    public static final Image manticore = new Image("view/images/monsters/manticore.png");
    public static final Image manticore_new = new Image("view/images/monsters/manticore_new.png");
    public static final Image minotaur = new Image("view/images/monsters/minotaur.png");
    public static final Image mnoleg = new Image("view/images/monsters/mnoleg.png");
    public static final Image moth_of_wrath = new Image("view/images/monsters/moth_of_wrath.png");
    public static final Image nazgul = new Image("view/images/monsters/nazgul.png");
    public static final Image ogre_lord = new Image("view/images/monsters/ogre_lord.png");
    public static final Image olog_hai = new Image("view/images/monsters/olog_hai.png");
    public static final Image orb_guardian = new Image("view/images/monsters/orb_guardian.png");
    public static final Image orc_high_priest = new Image("view/images/monsters/orc_high_priest.png");
    public static final Image orc_shaman = new Image("view/images/monsters/orc_shaman.png");
    public static final Image orc_warrior = new Image("view/images/monsters/orc_warrior.png");
    public static final Image pit_fiend = new Image("view/images/monsters/pit_fiend.png");
    public static final Image plains_centaur = new Image("view/images/monsters/plains_centaur.png");
    public static final Image python = new Image("view/images/monsters/python.png");
    public static final Image quasit = new Image("view/images/monsters/quasit.png");
    public static final Image queen_ant = new Image("view/images/monsters/queen_ant.png");
    public static final Image quicksilver_dragon = new Image("view/images/monsters/quicksilver_dragon.png");
    public static final Image redback = new Image("view/images/monsters/redback.png");
    public static final Image red_dragon = new Image("view/images/monsters/red_dragon.png");
    public static final Image rock_troll = new Image("view/images/monsters/rock_troll.png");
    public static final Image sandestin = new Image("view/images/monsters/sandestin.png");
    public static final Image sasquatch = new Image("view/images/monsters/sasquatch.png");
    public static final Image scorpion = new Image("view/images/monsters/scorpion.png");
    public static final Image serpent_of_hell = new Image("view/images/monsters/serpent_of_hell.png");
    public static final Image shadow_dragon = new Image("view/images/monsters/shadow_dragon.png");
    public static final Image shadow_fiend = new Image("view/images/monsters/shadow_fiend.png");
    public static final Image skeletal_dragon = new Image("view/images/monsters/skeletal_dragon.png");
    public static final Image skeletal_warrior = new Image("view/images/monsters/skeletal_warrior.png");
    public static final Image snorg = new Image("view/images/monsters/snorg.png");
    public static final Image soldier_ant = new Image("view/images/monsters/soldier_ant.png");
    public static final Image spectral_warrior = new Image("view/images/monsters/spectral_warrior.png");
    public static final Image storm_giant = new Image("view/images/monsters/storm_giant.png");
    public static final Image succubus = new Image("view/images/monsters/succubus.png");
    public static final Image tengu = new Image("view/images/monsters/tengu.png");
    public static final Image tiger = new Image("view/images/monsters/tiger.png");
    public static final Image titan = new Image("view/images/monsters/titan.png");
    public static final Image two_headed_ogre = new Image("view/images/monsters/two_headed_ogre.png");
    public static final Image unseen_horror = new Image("view/images/monsters/unseen_horror.png");
    public static final Image vampire = new Image("view/images/monsters/vampire.png");
    public static final Image vampire_bat = new Image("view/images/monsters/vampire_bat.png");
    public static final Image vampire_lord = new Image("view/images/monsters/vampire_lord.png");
    public static final Image vault_guardian = new Image("view/images/monsters/vault_guardian.png");
    public static final Image wraith = new Image("view/images/monsters/wraith.png");
    public static final Image wyvern = new Image("view/images/monsters/wyvern.png");
    public static final Image xan = new Image("view/images/monsters/xan.png");
    public static final Image xtahua = new Image("view/images/monsters/xtahua.png");
    public static final Image yeenoghu = new Image("view/images/monsters/yeenoghu.png");
    public static final Image yellow_dragon = new Image("view/images/monsters/yellow_dragon.png");
    public static final Image water_nymph = new Image("view/images/monsters/water_nymph.png");
    public static final Image hill_giant_hi = new Image("view/images/monsters/hill_giant_hi.png");
    public static final Image red_dragon_hi = new Image("view/images/monsters/red_dragon_hi.png");

    public static final String[] creatureNames = {"ancient_lich", "antaeus", "asmodeus", "asmodeus_new", "baby_purple_worm",
            "balrug", "beholder", "black_dragon", "black_naga", "blue_death", "bone_devil", "cacodemon",
            "carnivorous_ape", "cave_spider", "centipede", "cerebov", "cyclops", "deep_elf_death_mage",
            "deep_elf_fighter", "dispater", "dragon", "dwarf_king", "dwarf_lord", "efreet", "ereshkigal",
            "ettin", "ettin_new", "executioner", "eye_of_devastation", "fiend", "fire_giant", "flying_skull",
            "frost_giant", "gargoyle", "geryon", "ghoul", "giant_spider", "gloorx_vloq", "gnome_king",
            "gnomish_wizard", "golden_dragon", "gremlin", "hill_giant", "homunculus", "hydra", "ice_fiend",
            "imp", "incubus", "iron_dragon", "iron_troll", "killer_bee", "leprechaun", "lich", "lich_old",
            "lom_lobon", "manes", "manticore", "manticore_new", "minotaur", "mnoleg", "moth_of_wrath",
            "nazgul", "ogre_lord", "olog_hai", "orb_guardian", "orc_high_priest", "orc_shaman", "orc_warrior",
            "pit_fiend", "plains_centaur", "python", "quasit", "queen_ant", "quicksilver_dragon", "redback",
            "red_dragon", "rock_troll", "sandestin", "sasquatch", "scorpion", "serpent_of_hell", "shadow_dragon",
            "shadow_fiend", "skeletal_dragon", "skeletal_warrior", "snorg", "soldier_ant", "spectral_warrior",
            "storm_giant", "succubus", "tengu", "tiger", "titan", "two_headed_ogre", "unseen_horror", "vampire",
            "vampire_bat", "vampire_lord", "vault_guardian", "wraith", "wyvern", "xan", "xtahua", "yeenoghu",
            "yellow_dragon", "water_nymph", "hill_giant_hi", "red_dragon_hi"};

    public static final Image[] creaturePics = {ancient_lich, antaeus, asmodeus, asmodeus_new, baby_purple_worm, balrug,
            beholder, black_dragon, black_naga, blue_death, bone_devil, cacodemon, carnivorous_ape, cave_spider,
            centipede, cerebov, cyclops, deep_elf_death_mage, deep_elf_fighter, dispater, dragon, dwarf_king,
            dwarf_lord, efreet, ereshkigal, ettin, ettin_new, executioner, eye_of_devastation, fiend,
            fire_giant, flying_skull, frost_giant, gargoyle, geryon, ghoul, giant_spider, gloorx_vloq,
            gnome_king, gnomish_wizard, golden_dragon, gremlin, hill_giant, homunculus, hydra, ice_fiend,
            imp, incubus, iron_dragon, iron_troll, killer_bee, leprechaun, lich, lich_old, lom_lobon,
            manes, manticore, manticore_new, minotaur, mnoleg, moth_of_wrath, nazgul, ogre_lord, olog_hai,
            orb_guardian, orc_high_priest, orc_shaman, orc_warrior, pit_fiend, plains_centaur, python,
            quasit, queen_ant, quicksilver_dragon, redback, red_dragon, rock_troll, sandestin, sasquatch,
            scorpion, serpent_of_hell, shadow_dragon, shadow_fiend, skeletal_dragon, skeletal_warrior,
            snorg, soldier_ant, spectral_warrior, storm_giant, succubus, tengu, tiger, titan, two_headed_ogre,
            unseen_horror, vampire, vampire_bat, vampire_lord, vault_guardian, wraith, wyvern, xan, xtahua,
            yeenoghu, yellow_dragon, water_nymph, hill_giant_hi, red_dragon_hi};

    // weapons
    public static final Image athame = new Image("/view/images/weapons/athame.png");
    public static final Image battle_axe1 = new Image("/view/images/weapons/battle_axe1.png");
    public static final Image battle_axe2 = new Image("/view/images/weapons/battle_axe2.png");
    public static final Image boomerang = new Image("/view/images/weapons/boomerang.png");
    public static final Image broadsword = new Image("/view/images/weapons/broadsword.png");
    public static final Image copper = new Image("/view/images/weapons/copper.png");
    public static final Image crysknife = new Image("/view/images/weapons/crysknife.png");
    public static final Image demon_trident = new Image("/view/images/weapons/demon_trident.png");
    public static final Image elven_bow = new Image("/view/images/weapons/elven_bow.png");
    public static final Image hammer = new Image("/view/images/weapons/hammer.png");
    public static final Image morningstar = new Image("/view/images/weapons/morningstar.png");
    public static final Image orcish_bow = new Image("/view/images/weapons/orcish_bow.png");
    public static final Image sabre = new Image("/view/images/weapons/sabre.png");
    public static final Image scimitar = new Image("/view/images/weapons/scimitar.png");
    public static final Image scythe = new Image("/view/images/weapons/scythe.png");
    public static final Image staff1 = new Image("/view/images/weapons/staff1.png");
    public static final Image staff2 = new Image("/view/images/weapons/staff2.png");
    public static final Image sword1 = new Image("/view/images/weapons/sword1.png");
    public static final Image sword2 = new Image("/view/images/weapons/sword2.png");
    public static final Image tin = new Image("/view/images/weapons/tin.png");
    public static final Image hand_crossbow = new Image("/view/images/weapons/hand_crossbow.png");
    public static final Image staff_of_olgreb = new Image("/view/images/weapons/staff_of_olgreb.png");
    public static final Image sword_of_power = new Image("/view/images/weapons/sword_of_power.png");

    public static final String[] weaponNames = {"athame", "battle_axe1", "battle_axe2", "boomerang", "broadsword", "copper",
            "crysknife", "demon_trident", "elven_bow", "hammer", "morningstar", "orcish_bow", "saber", "scimitar",
            "scythe", "staff1", "staff2", "sword1", "sword2", "tin"};

    public static final Image[] weaponPics = {athame, battle_axe1, battle_axe2, boomerang, broadsword, copper, crysknife,
            demon_trident, elven_bow, hammer, morningstar, orcish_bow, sabre, scimitar, scythe, staff1, staff2,
            sword1, sword2, tin};

    // body armor
    public static final Image animal_skin = new Image("/view/images/armor/animal_skin.png");
    public static final Image banded_mail = new Image("/view/images/armor/banded_mail.png");
    public static final Image breast_plate = new Image("/view/images/armor/breast_plate.png");
    public static final Image cloak = new Image("/view/images/armor/cloak.png");
    public static final Image dragon_armor = new Image("/view/images/armor/dragon_armor.png");
    public static final Image dwarvish_cloak = new Image("/view/images/armor/dwarvish_cloak.png");
    public static final Image dwarvish_mithril_coat = new Image("/view/images/armor/dwarvish_mithril_coat.png");
    public static final Image elven_mithril_coat = new Image("/view/images/armor/elven_mithril_coat.png");
    public static final Image leather_armor = new Image("/view/images/armor/leather_armor.png");
    public static final Image opera_cloak = new Image("/view/images/armor/opera_cloak.png");
    public static final Image orcish_chain_mail = new Image("/view/images/armor/orcish_chain_mail.png");
    public static final Image splint_mail = new Image("/view/images/armor/splint_mail.png");
    public static final Image leather_armor2 = new Image("/view/images/armor/leather_armor2.png");
    public static final Image shimmering_dragon_scale_mail = new Image("/view/images/armor/shimmering_dragon_scale_mail.png");
    public static final Image orcish_platemail = new Image("/view/images/armor/orcish_platemail.png");
    public static final Image troll_leather_armor = new Image("/view/images/armor/troll_leather_armor.png");

    public static final String[] armorNames = {"animal_skin", "banded_mail", "breast_plate", "cloak", "dragon_armor",
            "dwarvish_cloak", "dwarvish_mithril_coat", "elven_mithril_coat", "leather_armor",
            "opera_cloak", "orcish_chain_mail", "splint_mail", "leather_armor2", "shimmering_dragon_scale_mail",
            "orcish_platemail", "troll_leather_armor"};

    public static final Image[] armorPics = {animal_skin, banded_mail, breast_plate, cloak, dragon_armor, dwarvish_cloak,
            dwarvish_mithril_coat, elven_mithril_coat, leather_armor, opera_cloak, orcish_chain_mail,
            splint_mail, leather_armor2, shimmering_dragon_scale_mail, orcish_platemail, troll_leather_armor};

    // treasure, misc items
    public static final Image book_of_the_dead = new Image("/view/images/treasure/book_of_the_dead.png");
    public static final Image candelabrum = new Image("/view/images/treasure/candelabrum.png");
    public static final Image celtic_amulet = new Image("/view/images/treasure/celtic_amulet.png");
    public static final Image chest = new Image("/view/images/treasure/chest.png");
    public static final Image credit_card = new Image("/view/images/treasure/credit_card.png");
    public static final Image crystal_ball = new Image("/view/images/treasure/crystal_ball.png");
    public static final Image diamond = new Image("/view/images/treasure/diamond.png");
    public static final Image emerald = new Image("/view/images/treasure/emerald.png");
    public static final Image gold = new Image("/view/images/treasure/gold.png");
    public static final Image jade_ring = new Image("/view/images/treasure/jade_ring.png");
    public static final Image ruby_ring = new Image("/view/images/treasure/ruby_ring.png");
    public static final Image sapphire = new Image("/view/images/treasure/sapphire.png");
    public static final Image sapphire_ring = new Image("/view/images/treasure/sapphire_ring.png");
    public static final Image shiny_ring = new Image("/view/images/treasure/shiny_ring.png");
    public static final Image skeleton_key = new Image("/view/images/treasure/skeleton_key.png");
    public static final Image spectral_amulet = new Image("/view/images/treasure/spectral_amulet.png");
    public static final Image spellbook = new Image("/view/images/treasure/spellbook.png");
    public static final Image trumpet = new Image("/view/images/treasure/trumpet.png");
    public static final Image unicorn_horn = new Image("/view/images/treasure/unicorn_horn.png");
    public static final Image violet_gem = new Image("/view/images/treasure/violet_gem.png");
    public static final Image life = new Image("/view/images/treasure/life.png");
    public static final Image magic = new Image("/view/images/treasure/magic.png");

    public static final String[] treasureNames = {"book_of_the_dead", "candelabrum", "celtic_amulet", "chest", "credit_card",
            "crystal_ball", "diamond", "emerald", "gold", "jade_ring", "ruby_ring", "sapphire", "sapphire_ring",
            "shiny_ring", "skeleton_key", "spectral_amulet", "spellbook", "trumpet", "unicorn_horn", "violet_gem", "life", "magic"};

    public static final Image[] treasurePics = {book_of_the_dead, candelabrum, celtic_amulet, chest, credit_card, crystal_ball,
            diamond, emerald, gold, jade_ring, ruby_ring, sapphire, sapphire_ring, shiny_ring, skeleton_key,
            spectral_amulet, spellbook, trumpet, unicorn_horn, violet_gem, life, magic};



    // testing testing testing: a visual map for display on the GUI that shows the dungeon
    public static final Image[][] mapOneImages =
            {{rock_wall09, rock_wall09, rock_wall09, water_nymph, rock_wall09, rock_wall09, rock_wall09},
             {rock_wall09, minotaur, lava, serpent_of_hell, lava, altar, rock_wall09},
             {sapphire_ring, floor, giant_spider, floor, floor, book_of_the_dead, rock_wall09},
             {floor, crystal_wall, crystal_wall, crystal_wall, floor, lich_old, floor},
             {imp, crystal_wall, life, spectral_warrior, floor, floor, rock_wall09},
             {chest, crystal_wall, python, crystal_wall, deep_water, raised_drawbridge_h, deep_water},
             {lava, crystal_wall, crystal_ball, crystal_wall, deep_water, dngn_enter_abyss, deep_water}};


    public static final Image[][] testMap = {{ice, ice, balrug, molten_lava},
                         {rock_wall15, imp, fiend, rock_wall10}};

    // for testing purposes, returns random picture of a category (creatures, weapons, ...)
    public static Image getRandomPic(Image[] images) {
        Random rand = new Random();
        return images[rand.nextInt(images.length)];
    }




}
