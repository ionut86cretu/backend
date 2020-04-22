package com.endava.school4it.memebook.controller;

import com.endava.school4it.memebook.dao.CommentDao;
import com.endava.school4it.memebook.dao.TopicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbInitController {

    @Autowired
    private TopicDao topicDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(path = "/db/init", method = RequestMethod.POST)
    public void dbInit() {
        topicDao.create("title wait", "assets/topics-images/picture_1.jpg", "Lina Clark");
        topicDao.create("title release", "assets/topics-images/picture_5.jpg", "Scott Mahoney");
        topicDao.create("title river", "assets/topics-images/picture_2.jpg", "Addyson Church");
        topicDao.create("title important", "assets/topics-images/picture_3.jpg", "Ayla Preston");
        topicDao.create("title mark", "assets/topics-images/picture_4.jpg", "Taylor Floyd");
        topicDao.create("title electric", "assets/topics-images/picture_6.jpg", "Zechariah Stokes");
        topicDao.create("title defective", "assets/topics-images/picture_7.jpg", "Jasmine Friedman");
        topicDao.create("title poke", "assets/topics-images/picture_8.jpg", "Konner Campos");
        topicDao.create("title blue", "assets/topics-images/picture_9.jpg", "Malaki Erickson");
        topicDao.create("title beef", "assets/topics-images/picture_10.jpg", "Fatima Hatfield");
        topicDao.create("title spring", "https://scontent.fotp3-3.fna.fbcdn.net/v/t1.0-9/92579247_124627945845098_7799417686185738240_n.jpg?_nc_cat=104&_nc_sid=110474&_nc_ohc=8m26tSY9TUsAX-DNRxC&_nc_ht=scontent.fotp3-3.fna&oh=97c8046fd540abb21a9b6ce98e3b8da6&oe=5EBB7FD4", "Angel Myers");
        topicDao.create("title hurt", "https://i.pinimg.com/564x/0e/fb/6a/0efb6acdd65a54abbe43014d7b7f058e.jpg", "Luka Riddle");
        topicDao.create("title orange", "https://scontent.fotp3-1.fna.fbcdn.net/v/t1.0-9/91621174_1314668228922159_7846791377324081152_n.jpg?_nc_cat=111&_nc_sid=8024bb&_nc_ohc=AoCQJkMzkJQAX8sAgSw&_nc_ht=scontent.fotp3-1.fna&oh=9c64a619a69280aa5bab5bc1e2e44189&oe=5EBC2BD3", "Allison Ortega");
        topicDao.create("title happy", "https://i.pinimg.com/564x/01/71/56/017156abf36b035339f5c06a6ac3be6c.jpg", "Amaya Hawkins");
        topicDao.create("title zealous", "https://scontent.fotp3-2.fna.fbcdn.net/v/t1.0-9/s960x960/53039138_251344585742286_7043797144838340608_o.jpg?_nc_cat=105&_nc_sid=8024bb&_nc_ohc=j5Khp63OrbUAX9nIVkJ&_nc_ht=scontent.fotp3-2.fna&_nc_tp=7&oh=8b65dfc1c46e1fe8c7cab6b8ffed3b65&oe=5EBA85F7", "Jamar Huerta");
        topicDao.create("title flowery", "https://i.pinimg.com/564x/53/3a/4e/533a4efa2810998936a42f1fa291e6e1.jpg", "Emmanuel Oneill");
        topicDao.create("title accurate", "https://scontent.fotp3-1.fna.fbcdn.net/v/t1.0-9/s960x960/93117970_10163348986795161_4976560017256742912_o.jpg?_nc_cat=1&_nc_sid=2d5d41&_nc_ohc=E398Exb35mUAX8YZETG&_nc_ht=scontent.fotp3-1.fna&_nc_tp=7&oh=adce42317a374faa632f095d1dd8398a&oe=5EBA6808", "Genesis Simmons");
        topicDao.create("title brake", "https://i.pinimg.com/564x/cb/2b/9b/cb2b9b5c6727e98f6cd24ca0e114ca60.jpg", "Charles Goodwin");
        topicDao.create("title title", "https://i.pinimg.com/564x/b2/d2/16/b2d21601a6979e427d166ecacf316c4d.jpg", "Natalia Barr");
        topicDao.create("title x-ray", "https://i.pinimg.com/564x/c5/fe/03/c5fe037aecdf011e307a05cdb810f25e.jpg", "Saniyah Holloway");
        topicDao.create("title festive", "https://img-9gag-fun.9cache.com/photo/a0RApRQ_700bwp.webp", "Leila Robinson");
        topicDao.create("title wrathful", "https://preview.redd.it/285ce1dqnus41.jpg?width=640&crop=smart&auto=webp&s=c5b11c8a0a646aa51f2eaaf6efc63c3a24939e50", "Marisa Browning");
        topicDao.create("title scissors", "https://img-9gag-fun.9cache.com/photo/awowob8_460swp.webp", "Cornelius Page");
        topicDao.create("title peaceful", "https://img-9gag-fun.9cache.com/photo/az1pRPN_460swp.webp", "Jesus Middleton");
        topicDao.create("title finicky", "https://preview.redd.it/w089usdblvs41.png?width=640&crop=smart&auto=webp&s=11691baff7c17536524539745f6056200069765d", "Nia Shaffer");
        topicDao.create("title shape", "https://img-9gag-fun.9cache.com/photo/az1B0yK_460swp.webp", "Miley Singleton");
        topicDao.create("title soothe", "https://preview.redd.it/nfjw7jy69er41.jpg?width=640&crop=smart&auto=webp&s=2cb76ec99cff32017c82c014b0ac24ecf284330b", "Giada Stephenson");
        topicDao.create("title head", "https://img-9gag-fun.9cache.com/photo/aN0jwxv_460swp.webp", "Sawyer Bartlett");
        topicDao.create("title spotted", "https://preview.redd.it/1vernvhkcxs41.jpg?width=640&crop=smart&auto=webp&s=315a23a8c6dc61c52d7d527c989fb83bd988a7a9", "Donovan Weber");
        topicDao.create("title needless", "https://preview.redd.it/tysyibp31xs41.jpg?width=960&crop=smart&auto=webp&s=9e30d9295705ad86a17998e8e14bb5d19bf8b13c", "Albert Arnold");
        topicDao.create("title time", "https://2.bp.blogspot.com/-IpWBrLhAB6w/XMaWK4Z5KDI/AAAAAAAAAJA/10joEkrrAYYUdQhVOeqTrIyElNkhccA7ACLcBGAs/s1600/IMG_20190427_201318_572.jpg", "Abram Schwartz");
        topicDao.create("title abundant", "https://codinginfinite.com/wp-content/uploads/2019/05/maxresdefault-1.jpg", "Braeden Shelton");
        topicDao.create("title humdrum", "https://www.testbytes.net/wp-content/uploads/2019/06/Untitled-1.png", "Katherine Ferguson");
        topicDao.create("title mouth", "https://code-love.com/wp-content/uploads/2019/04/got-a-new-error.jpeg", "Marshall Spears");
        topicDao.create("title trot", "https://pics.astrologymemes.com/daca-viata-iti-intoarce-spatele-fura-i-portofelul-giovani-jacmanel-viata-7024048.png", "Samantha Duarte");
        topicDao.create("title bounce", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSVOVMK6laI49zFDCmsFi1-sQRu4_D5Uhlt7w5IigR6vLAYuicY&usqp=CAU", "Ali Koch");
        topicDao.create("title thank", "https://scontent-yyz1-1.cdninstagram.com/v/t51.2885-15/sh0.08/e35/c46.0.987.987a/s640x640/88228386_226326188494302_2171432898648613030_n.jpg?_nc_ht=scontent-yyz1-1.cdninstagram.com&_nc_cat=106&_nc_ohc=51EcWfWP034AX8mv41A&oh=7ac41afd7685b2ab72b19833bb851422&oe=5E9768B3", "Vanessa Pratt");
        topicDao.create("title avoid", "https://scontent-waw1-1.cdninstagram.com/v/t51.2885-15/e35/c44.0.632.632a/81715080_522172271758462_3922304516981358475_n.jpg?_nc_ht=scontent-waw1-1.cdninstagram.com&_nc_cat=110&_nc_ohc=fK1pxDARZaAAX9xhFzl&oh=be01e0246bd927702572603db6324daf&oe=5ED5C878", "Martha Daniels");
        topicDao.create("title shocking", "https://d.wattpad.com/story_parts/16/images/141d758ed0ce0caa.jpg", "Ricardo Mahoney");
        topicDao.create("title minor", "https://i.pinimg.com/236x/fc/4e/bd/fc4ebd7069fae4224d6eff5841f91f9f.jpg", "Aleena Marsh");
        topicDao.create("title secret", "https://i.pinimg.com/236x/a4/4e/a3/a44ea33d229c932d89c183f9cca50c0c.jpg", "Joy Roth");
        topicDao.create("title rabbit", "https://i.pinimg.com/236x/fe/b5/1a/feb51aad861b69eed880970336755af9.jpg", "Mateo Welch");
        topicDao.create("title protect", "https://i.pinimg.com/236x/39/81/bd/3981bde531b7a9b1673bf960f0fd6080.jpg", "Aldo Gonzales");
        topicDao.create("title honey", "https://i.pinimg.com/564x/37/68/cf/3768cfe572a3399b68dbd0a9ccdc8b7f.jpg", "Abigayle Lynn");
        topicDao.create("title business", "https://i.pinimg.com/236x/1a/fd/b7/1afdb731e3e8bc948a715e54d8ee6ed5.jpg", "Gillian Klein");
        topicDao.create("title worthless", "https://i.pinimg.com/236x/64/56/cc/6456cc268a8974a239d01ed94cc87f22.jpg", "Marely Lewis");
        topicDao.create("title suggest", "https://i.pinimg.com/236x/36/3e/bb/363ebb3e576c3babc1f79c113ff30a7e.jpg", "Lucian Dorsey");
        topicDao.create("title splendid", "https://i.pinimg.com/236x/64/31/ec/6431ecb41ebae6cdc6a69cab4c24aab8.jpg", "Alec Kirk");
        topicDao.create("title drab", "https://i.pinimg.com/236x/73/23/6a/73236a4f4b22d61ae4b136010e5bacd9.jpg", "Paul Reilly");

        commentDao.create(1L, "MonaLisa", "Cool");
        commentDao.create(1L, "Gigel", "Tre Cool");
        commentDao.create(2L, "MonaLisa", "Cool");

    }
}
