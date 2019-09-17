using Microsoft.EntityFrameworkCore.Migrations;

namespace NearbyShop.Migrations
{
    public partial class adddescriptiontoshop : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "description",
                table: "Shop",
                nullable: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "description",
                table: "Shop");
        }
    }
}
