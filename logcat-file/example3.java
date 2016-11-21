 try {
      Process process = Runtime.getRuntime().exec("logcat -dv long");

      reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      FileWriter fWriter = new FileWriter(file, appendToExistingLogs);
      writer = new BufferedWriter(fWriter);

      String line;
      while ((line = reader.readLine()) != null) {
        writer.write(line + "\n");
      }
      Runtime.getRuntime().exec("logcat -c");

    } catch (IOException e) {
      LOG.error("Error when trying to dump log file!", e);
    } finally {
      try {
        reader.close();
        writer.close();
      } catch (Exception e) {
        LOG.error("Error when trying to close reader and writer!", e);
      }
    }