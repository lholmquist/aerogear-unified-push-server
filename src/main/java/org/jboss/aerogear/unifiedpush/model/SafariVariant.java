package org.jboss.aerogear.unifiedpush.model;

import org.jboss.aerogear.unifiedpush.api.VariantType;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("'safari'")
public class SafariVariant extends AbstractVariant {

    private static final long serialVersionUID = -889367404039436339L;

    public SafariVariant() {
        super();
        // we are Safari:
        this.setType(VariantType.SAFARI);
    }

    @Column
    private boolean production = true;

    @Column
    @NotNull
    @Size(max = 255)
    private String passphrase;

    @Lob
    @Column(name = "CERT")
    @NotNull
    private byte[] certificate;

    /**
     * If <code>true</code> a connection to Apple's Production APNs server
     * will be established for this Safari variant.
     *
     * Currently Safari push notifications only support Apple's Proudction APNs server
     */
    public boolean isProduction() {
        return production;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) {
        this.certificate = certificate;
    }
}
