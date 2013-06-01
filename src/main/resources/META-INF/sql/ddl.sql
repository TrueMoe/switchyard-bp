CREATE TABLE GasStation(
  Id INT PRIMARY KEY,
  Name VARCHAR(255)
);

CREATE TABLE Expenses ( 
  Id INT PRIMARY KEY,
  GasStationId INT UNIQUE REFERENCES GasStation(Id),
  Day INT NOT NULL,
  Amount DECIMAL(20, 2)
);

CREATE TABLE Revenues ( 
  Id INT PRIMARY KEY,
  GasStationId INT UNIQUE REFERENCES GasStation(Id),
  Day INT NOT NULL,
  Amount DECIMAL(20, 2)
);
