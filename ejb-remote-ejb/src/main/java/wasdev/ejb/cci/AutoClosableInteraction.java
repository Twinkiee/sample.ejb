package wasdev.ejb.cci;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.Interaction;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;
import javax.resource.cci.ResourceWarning;

public class AutoClosableInteraction implements Interaction, AutoCloseable {

  private final Interaction interaction;

  public AutoClosableInteraction(Interaction interaction) {
    this.interaction = interaction;
  }

  @Override
  public void close() throws ResourceException {
    interaction.close();
  }

  @Override
  public Connection getConnection() {
    return interaction.getConnection();
  }

  @Override
  public boolean execute(InteractionSpec ispec, Record input,
      Record output) throws ResourceException {
    return interaction.execute(ispec, input, output);
  }

  @Override
  public Record execute(InteractionSpec ispec,
      Record input) throws ResourceException {
    return interaction.execute(ispec, input);
  }

  @Override
  public ResourceWarning getWarnings() throws ResourceException {
    return interaction.getWarnings();
  }

  @Override
  public void clearWarnings() throws ResourceException {
    interaction.clearWarnings();
  }
}
