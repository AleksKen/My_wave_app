DROP TABLE IF EXISTS tracks;

CREATE TABLE tracks (
    id bigint GENERATED ALWAYS AS IDENTITY,
    title varchar(255),
    artist varchar(255),
    file varchar(255),
    cluster varchar(50)
);

INSERT INTO tracks (title, artist, file) VALUES
('Roller Coaster', 'Danny Vera', '/Users/mariakonasova/My_wave_app/src/main/resources/MediaLibrary/Danny Vera - Roller Coaster.mp3'),
('Arcade', 'Duncan Laurence', '/Users/mariakonasova/My_wave_app/src/main/resources/MediaLibrary/Duncan Laurence feat. Fletcher - Arcade.mp3'),
('A Whiter Shade of Pale - Original Single Version', 'Procol Harum', '/Users/mariakonasova/My_wave_app/src/main/resources/MediaLibrary/Procol Harum - A Whiter Shade Of Pale.mp3'),
('The Load-Out - Remastered', 'Jackson Browne', '/Users/mariakonasova/My_wave_app/src/main/resources/MediaLibrary/Jackson_Browne_-_The_Load_Out_(SkySound.cc).mp3'),
('Last Christmas', 'Wham!', '/Users/mariakonasova/My_wave_app/src/main/resources/MediaLibrary/Wham! - Last Christmas.mp3'),
('Time To Give', 'White Lies', '/Users/mariakonasova/My_wave_app/src/main/resources/MediaLibrary/White Lies - Time To Give.mp3'),
('bad guy', 'Billie Eilish', '/Users/mariakonasova/My_wave_app/src/main/resources/MediaLibrary/Billie Eilish - Bad Guy.mp3'),
('Memories', 'Maroon 5', '/Users/mariakonasova/My_wave_app/src/main/resources/MediaLibrary/Maroon 5 - Memories.mp3'),
('Love Like Blood', 'Killing Joke', '/Users/mariakonasova/My_wave_app/src/main/resources/MediaLibrary/Killing Joke - Love Like Blood.mp3'),
('DEUTSCHLAND', 'Rammstein', '/Users/mariakonasova/My_wave_app/src/main/resources/MediaLibrary/Rammstein - DeutschLand.mp3'),
('Phantom Of The Opera', 'Floor Jansen', '/Users/mariakonasova/My_wave_app/src/main/resources/MediaLibrary/Floor_Jansen_Henk_Poort_-_Phantom_Of_The_Opera_66948308.mp3'),
('Dance Monkey', 'Tones and I', '/Users/mariakonasova/My_wave_app/src/main/resources/MediaLibrary/Tones and I - Dance Monkey.mp3'),
('Blauwe Dag', 'Suzan & Freek', '/Users/mariakonasova/My_wave_app/src/main/resources/MediaLibrary/Suzan & Freek - Blauwe Dag.mp3'),
('Despacito', 'Luis Fonsi', '/Users/mariakonasova/My_wave_app/src/main/resources/MediaLibrary/Luis Fonsi - Despacito.mp3');
