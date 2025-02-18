package solvd.army;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Rank")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rank {
	@XmlAttribute
    private long id;
	@XmlElement
    private String rank_name;
	@XmlTransient
    private Soldier soldier;
	@XmlTransient
    private long soldier_id;

    public Rank(int id, String rank_name, Soldier soldier) {
        this.id = id;
        this.rank_name = rank_name;
        this.soldier = soldier;
    }
    
    public Rank() {}

    public long getId() {
		return id;
	}

    public void setId(long id) {
		this.id = id;
	}

    public String getRankName() {
		return rank_name;
	}

    public void setRankName(String rankName) {
		this.rank_name = rankName;
	}

    public Soldier getSoldier() {
		return soldier;
	}

    public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
	}
	
    public long getSoldierId() {
		return soldier_id;
	}

    public void setSoldierId(long soldier_id) {
		this.soldier_id = soldier_id;
	}

}
