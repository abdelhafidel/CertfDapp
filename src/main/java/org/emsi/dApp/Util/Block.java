package org.emsi.dApp.Util;

import java.security.MessageDigest;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import org.emsi.dApp.metier.BlockChain;
import org.emsi.dApp.metier.Certif;


public class Block {

	private int index;
	private String hash;
	private String previousHash;
	private Certif certif;
	private long timeStamp;
	private int nonce;

	public Block(int index, Certif certif, String previousHash, long timeStamp) {
		this.index = index;
		this.certif = certif;
		this.previousHash = previousHash;
		this.timeStamp = timeStamp;
		this.hash = calculateBlockHash();
	}
	
	public Block() {

	}

	// create the first block
	public  Block getGenesisBlock() {
		long timeStamp = new Date().getTime();
		return new Block(0, new Certif(), null, timeStamp);
	}

	// to calculate hash with sha-256
	public String calculateBlockHash() {

		String hashValue = "";

		String certifToHash = this.previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + this.certif;

		MessageDigest messageDigest = null;

		byte[] bytes = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(certifToHash.getBytes());

			bytes = messageDigest.digest();

			hashValue = DatatypeConverter.printHexBinary(bytes).toLowerCase();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return hashValue;
	}

	// verify the block
	public boolean isValidNewBlock(BlockChain prevBlock) {

		if (prevBlock.getIdBlock() + 1 != this.index) {
			System.out.println("invalid index " + this);
			return false;
		}

		if (prevBlock.getHash() != this.previousHash) {
			System.out.println("invalid previousHash " + this);
			return false;
		}

		if (!this.calculateBlockHash().equals(this.getHash())) {
			System.out.println("invalid hash " + this);
			return false;
		}

		return true;
	}

	// validate the block after verify minage(POW)
	// this step is before add it to the chain
	public String mineBlock(int prefix) {
		String prefixString = new String(new char[prefix]).replace('\0', '0');
		while (!hash.substring(0, prefix).equals(prefixString)) {
			nonce++;
			hash = calculateBlockHash();
		}
		return hash;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Certif getcertif() {
		return certif;
	}

	public void setcertif(Certif certif) {
		this.certif = certif;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getHash() {
		return hash;
	}

	public String getPreviousHash() {
		return previousHash;
	}
	

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}
	
	

	public void setHash(String hash) {
		this.hash = hash;
	}

	
	public int getNonce() {
		return nonce;
	}

	public void setNonce(int nonce) {
		this.nonce = nonce;
	}

	@Override
	public String toString() {
		return "Block [index=" + index + ", hash=" + hash + ", previousHash=" + previousHash + ", certif=" + certif
				+ ", timeStamp=" + timeStamp + ", nonce=" + nonce + "]";
	}

}
