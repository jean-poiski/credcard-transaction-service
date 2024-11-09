SELECT 'CREATE DATABASE credcarddb'
  WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'credcarddb');