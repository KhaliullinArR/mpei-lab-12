DROP TABLE IF EXISTS stats;

CREATE TABLE  stats(
  id INT PRIMARY KEY AUTO_INCREMENT,
  word_i  DECIMAL NOT NULL,
  word_h DECIMAL,
  word_n INT NOT NULL,
  word_b DECIMAL,
  word_m DECIMAL,
  word_c DECIMAL
);

INSERT INTO stats (word_i, word_n) VALUES
    (0.075, 75),
    (0.070, 73),
    (0.065, 70),
    (0.060, 67),
    (0.055, 65),
    (0.050, 63),
    (0.045, 57),
    (0.040, 55),
    (0.035, 51),
    (0.030, 47),
    (0.025, 39),
    (0.020, 30),
    (0.015, 24),
    (0.010, 14),
    (0.005, 8);


