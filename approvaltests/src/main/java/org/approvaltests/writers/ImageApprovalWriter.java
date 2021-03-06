package org.approvaltests.writers;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.approvaltests.core.ApprovalWriter;

import com.spun.util.ObjectUtils;

public class ImageApprovalWriter implements ApprovalWriter
{
  private final BufferedImage image;
  public ImageApprovalWriter(BufferedImage image)
  {
    this.image = image;
  }
  @Override
  public String writeReceivedFile(String received)
  {
    ObjectUtils.throwAsError(() -> ImageIO.write(image, "png", new File(received)));
    return received;
  }
  @Override
  public String getApprovalFilename(String base)
  {
    return base + Writer.approved + ".png";
  }
  @Override
  public String getReceivedFilename(String base)
  {
    return base + Writer.received + ".png";
  }
}
