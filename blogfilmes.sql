use blogfilmes;
select*from tb_mypostagens;
insert into tb_mypostagens(filme,descricao,date)values("Poderoso Chefão II","Adeus fredo",current_timestamp() /* ,'1975-14-02*/);
insert into tb_mypostagens(filme,descricao,date)values("O Senhor dos Anéis: A Sociedade do Anel",
"Em uma terra fantástica e única, um hobbit recebe de presente de seu tio um anel mágico e maligno",current_timestamp()/*,default,01-01-2001*/);
insert into tb_mypostagens(filme,descricao,date)values("O Sistema",
"Quando a jovem e ambiciosa Sarah Moss é contratada por uma empresa privada de informações, ela é imediatamente enviada a uma perigosa missão como agente disfarçada"
,current_timestamp()/*,default,31-05-2013*/);
insert into tb_mypostagens(filme,descricao,date)values("O Paizão",
"Sonny Koufax tem 32 anos de idade e passou toda a sua vida fugindo das responsabilidades.",current_timestamp()/* ,default,08-10-1999*/);
insert into tb_mypostagens(filme,descricao,date)values("Rock IV",
"Após Apollo Creed, é espancado até a morte por Ivan Dragon Rocky decide ir até a União Soviética para enfrentá-lo e vingar o amigo",current_timestamp() /*,default,17-01-1986*/);
select*from tb_mypostagens;
-- drop database blogfilmes;