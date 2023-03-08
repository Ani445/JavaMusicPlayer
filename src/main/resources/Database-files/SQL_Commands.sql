

# select T2.*, artist.first_name, artist.last_name from
#     (select T1.*, song_artist.ARTIST_ID from (select song.*, album.NAME as ALBUM from song left join album on song.ALBUM_ID = album.ALBUM_ID) T1
#         left join song_artist on T1.SONG_ID = song_artist.SONG_ID) T2 left join artist
#         on T2.ARTIST_ID = artist.ARTIST_ID;

insert into user values('abesh', 'owl', 'Abesh', 'Ahsan', NULL);
insert into user values('sahab', 'cholonajai', 'Sahab', 'Al-Chowdhury', NULL);
insert into user values('fry', 'ghumpaise', 'Anika', 'Farzana', NULL);
insert into user values('adib', 'bolbona', 'Adib', 'Farhan', NULL);


insert into artist (FIRST_NAME, LAST_NAME) values ('Alan', 'Walker');
insert into artist (FIRST_NAME, LAST_NAME) values ('Zainab', 'RMX');
insert into artist (FIRST_NAME, LAST_NAME) values ('Coldplay', '');
insert into artist (FIRST_NAME, LAST_NAME) values ('Jaymes',  'Young');
insert into artist (FIRST_NAME, LAST_NAME) values ('Eminem',  '');
insert into artist (FIRST_NAME, LAST_NAME) values ('Sia',  '');
insert into artist (FIRST_NAME, LAST_NAME) values ('Selena', 'Gomez');

insert into album (NAME, ARTIST_ID) values ('Different World', '1');
insert into album (NAME, ARTIST_ID) values ('Zainab RMX - Bali Street', '2');
insert into album (NAME, ARTIST_ID) values ('A head full of dreams', '3');
insert into album (NAME, ARTIST_ID) values ('Infinity', '4');
insert into album (NAME, ARTIST_ID) values ('Mockingbird', '5');
insert into album (NAME, ARTIST_ID) values ('1000 forms of fear', '6');
insert into album (NAME, ARTIST_ID) values ('People you know', '7');
insert into album (NAME, ARTIST_ID) values ('This is Something', '6');

insert into song (NAME, PATH, ALBUM_ID) values ('Faded', 'G:/Downloads/Alan_Walker_Faded.mp3', '1');
insert into song (NAME, PATH, ALBUM_ID) values ('Darkside', 'G:/Downloads/Alan_Walker_Darkside_feat_AuRa_and_Tomine_Harket.mp3', '1');
insert into song (NAME, PATH, ALBUM_ID) values ('The True Leader', 'G:/Downloads/Alan_Walker_The_True_Leader_Official_Video.mp3', '2');
insert into song (NAME, PATH, ALBUM_ID) values ('Hymn for the weekend', 'G:/Downloads/Coldplay_Hymn_For_The_Weekend_Official_Video.mp3', '3');
insert into song (NAME, PATH, ALBUM_ID) values ('Birds', 'G:/Downloads/Coldplay_Birds_Official_Video.mp3', '3');
insert into song (NAME, PATH, ALBUM_ID) values ('Infinity', 'G:/Downloads/Jaymes_Young_Infinity_Official_Audio.mp3', '4');
insert into song (NAME, PATH, ALBUM_ID) values ('Mockingbird', 'G:/Downloads/Eminem_Mockingbird_Official_Music_Video.mp3', '5');
insert into song (NAME, PATH, ALBUM_ID) values ('Chandelier', 'G:/Downloads/Sia_Chandelier_Official_Video.mp3', '6');
insert into song (NAME, PATH, ALBUM_ID) values ('The greatest',  'G:/Downloads/Sia_The_Greatest.mp3', '8');
insert into song (NAME, PATH, ALBUM_ID) values ('People you know', 'G:/Downloads/Selena_Gomez_People_You_Know_Official_Lyrics.mp3', '7');


insert into song_artist (SONG_ID, ARTIST_ID) values ('1', '1');
insert into song_artist (SONG_ID, ARTIST_ID) values ('2', '1');
insert into song_artist (SONG_ID, ARTIST_ID) values ('3', '2');
insert into song_artist (SONG_ID, ARTIST_ID) values ('4',  '3');
insert into song_artist (SONG_ID, ARTIST_ID) values ('5',  '3');
insert into song_artist (SONG_ID, ARTIST_ID) values ('6',  '4');
insert into song_artist (SONG_ID, ARTIST_ID) values ('7',  '5');
insert into song_artist (SONG_ID, ARTIST_ID) values ('8', '6');
insert into song_artist (SONG_ID, ARTIST_ID) values ('9', '6');
insert into song_artist (SONG_ID, ARTIST_ID) values ('10', '7');
